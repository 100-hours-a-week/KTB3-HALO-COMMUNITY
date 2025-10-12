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
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // -- C --
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<ApiResponse<CommentCreateRes>> create(@PathVariable Long postId, @RequestBody CommentCreateReq commentCreateReq) {
        CommentCreateRes res = commentService.createComment(postId, commentCreateReq);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(SuccessCode.COMMENT_CREATE_SUCCESS, res));
    }


    // -- R --
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<ApiResponse<CommentListRes>> getCommentList(@PathVariable Long postId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        CommentListRes res = commentService.getCommentList(postId, page, size);

        if (res.comments().isEmpty()) {
            return ResponseEntity.ok(ApiResponse.success(SuccessCode.COMMENT_LIST_EMPTY, res));
        }

        return ResponseEntity.ok(ApiResponse.success(SuccessCode.COMMENT_LIST_READ_SUCCESS, res));
    }
    @GetMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse<CommentDetailRes>> getCommentDetail(@PathVariable Long commentId) {
        CommentDetailRes res = commentService.getCommentDetail(commentId);
        return ResponseEntity.ok(ApiResponse.success(SuccessCode.COMMENT_READ_SUCCESS, res));
    }


    // -- U --
    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse<CommentUpdateRes>> updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentUpdateReq req
    ) {
        CommentUpdateRes res = commentService.updateComment(commentId, req);
        return ResponseEntity.ok(ApiResponse.success(SuccessCode.COMMENT_UPDATE_SUCCESS, res));
    }


    // -- D --
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse<CommentDeleteRes>> deleteComment(
            @PathVariable Long commentId
    ) {
        CommentDeleteRes res = commentService.deleteComment(commentId);
        return ResponseEntity.ok(ApiResponse.success(SuccessCode.COMMENT_DELETE_SUCCESS, res));
    }


}





