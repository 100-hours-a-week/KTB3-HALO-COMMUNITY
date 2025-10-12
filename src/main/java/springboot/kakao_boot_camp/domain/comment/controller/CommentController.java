package springboot.kakao_boot_camp.domain.comment.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.kakao_boot_camp.domain.comment.dto.CommentDtos.*;
import springboot.kakao_boot_camp.domain.comment.service.CommentService;
import springboot.kakao_boot_camp.domain.post.dto.PostDtos;
import springboot.kakao_boot_camp.global.api.ApiResponse;
import springboot.kakao_boot_camp.global.api.SuccessCode;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // -- C --
    @PostMapping("/{postId}/comments")
    public ResponseEntity<ApiResponse<CommentCreateRes>> create(@PathVariable Long postId, @RequestBody CommentCreateReq commentCreateReq) {
        CommentCreateRes res = commentService.createComment(postId, commentCreateReq);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(SuccessCode.COMMENT_CREATE_SUCCESS, res));
    }


}
