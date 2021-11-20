package com.dndhackathon.healthy_honey_tving.domain.react.service;

import com.dndhackathon.healthy_honey_tving.domain.post.repository.PostRepository;
import com.dndhackathon.healthy_honey_tving.domain.post.repository.UserRepository;
import com.dndhackathon.healthy_honey_tving.domain.react.dto.ReactRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.react.exception.AlreadyReactedException;
import com.dndhackathon.healthy_honey_tving.domain.react.exception.DataNotFoundException;
import com.dndhackathon.healthy_honey_tving.domain.react.exception.NotReactYetException;
import com.dndhackathon.healthy_honey_tving.domain.react.repository.ReactRepository;
import com.dndhackathon.healthy_honey_tving.global.entity.PostEntity;
import com.dndhackathon.healthy_honey_tving.global.entity.ReactEntity;
import com.dndhackathon.healthy_honey_tving.global.entity.UserEntity;
import com.dndhackathon.healthy_honey_tving.global.enum_type.React;
import com.dndhackathon.healthy_honey_tving.global.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReactServiceImpl implements ReactService{
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final ReactRepository reactRepository;

    @Override
    public void addReact(ReactRequestDto requestDto) {
        Optional<UserEntity> user = userRepository.findById(requestDto.getUserUID());
        Optional<PostEntity> post = postRepository.findById(requestDto.getPostUID());

        if(user.isEmpty() || post.isEmpty()) throw new DataNotFoundException("데이터가 존재하지 않습니다! post 나 user 중 하나이상이 존재하지 않습니다!");

        if(reactRepository.existsAllByPostEntityAndUserEntity(post.get(), user.get())) {
            if(reactRepository.existsAllByPostEntityAndUserEntityAndReact(post.get(), user.get(), requestDto.getReact()))
                throw new AlreadyReactedException(String.format("이미 %s를 누른 상태입니다.",
                        requestDto.getReact().equals(React.BAD) ? "싫어요" : "좋아요"));
            else reactRepository.removeReactEntityByPostEntityAndUserEntity(post.get(), user.get());
        }
        reactRepository.save(new ReactEntity(-1L, user.get(), post.get(), requestDto.getReact()));
    }

    @Override
    public void removeReact(ReactRequestDto requestDto) {
        Optional<UserEntity> user = userRepository.findById(requestDto.getUserUID());
        Optional<PostEntity> post = postRepository.findById(requestDto.getPostUID());

        if(user.isEmpty() || post.isEmpty()) throw new DataNotFoundException("잘못된 요청입니다. post 나 user 중 하나이상이 존재하지 않습니다!");

        if(!reactRepository.existsAllByPostEntityAndUserEntityAndReact(post.get(), user.get(), requestDto.getReact()))
            throw new NotReactYetException(String.format("%s를 누르지 않은 상태입니다.",
                    requestDto.getReact().equals(React.BAD) ? "싫어요" : "좋아요"));

        reactRepository.removeReactEntityByPostEntityAndUserEntity(post.get(), user.get());
    }

    @ExceptionHandler(NotReactYetException.class)
    public ResponseEntity<ErrorResponse> notReactYetException(NotReactYetException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage(), ErrorResponse.Code.NOT_REACT_YET));
    }

    @ExceptionHandler(AlreadyReactedException.class)
    public ResponseEntity<ErrorResponse> alreadyReactedException(AlreadyReactedException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage(), ErrorResponse.Code.ALREADY_REACTED));
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> dataNotFoundException(DataNotFoundException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage(), ErrorResponse.Code.DATA_NOT_FOUND));
    }
}
