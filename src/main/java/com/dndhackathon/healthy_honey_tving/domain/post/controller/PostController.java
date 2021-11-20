package com.dndhackathon.healthy_honey_tving.domain.post.controller;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.post.dto.RemovePostRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.post.service.PostService;
import com.dndhackathon.healthy_honey_tving.global.dto.PostDto;
import com.dndhackathon.healthy_honey_tving.global.error.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;

    @PutMapping("/post")
    public ResponseEntity<Long> post(@RequestBody AddPostRequestDto requestDto) {
        long postUID = postService.addPost(requestDto);
        return ResponseEntity.ok().body(postUID);
    }

    @DeleteMapping("/post")
    public ResponseEntity<Void> deletePost(@RequestBody RemovePostRequestDto requestDto) {
        PostDto post = postService.getPost(requestDto.postUID());
        if(post.userUID().longValue() != requestDto.userUID().longValue())
            throw new PermissionDeniedDataAccessException("게시글은 작성자만이 지울 수 있습니다.", null);
        postService.removePost(requestDto.postUID());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(PermissionDeniedDataAccessException.class)
    public ResponseEntity<ErrorResponse> handlePermissionDeniedDataAccessException(PermissionDeniedDataAccessException e) {
        return ResponseEntity.status(403).body(new ErrorResponse(e.getMessage(), ErrorResponse.Code.PERMISSION_DENIED));
    }


}
