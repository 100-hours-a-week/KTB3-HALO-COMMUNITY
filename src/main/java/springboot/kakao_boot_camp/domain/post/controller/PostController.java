package springboot.kakao_boot_camp.domain.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.kakao_boot_camp.domain.post.Service.PostService;
import springboot.kakao_boot_camp.domain.post.dto.PostDtos.*;
import springboot.kakao_boot_camp.global.api.ApiResponse;
import springboot.kakao_boot_camp.global.api.SuccessCode;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    // -- C --
    @PostMapping
    public ResponseEntity<ApiResponse<PostCreateRes>> create(@RequestBody @Valid PostCreateReq req) {
        PostCreateRes res = postService.createPost(req);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(SuccessCode.POST_CREATE_SUCCESS, res));
    }


    // -- R --
    @GetMapping
    public ResponseEntity<ApiResponse<PostListRes>> getList(@RequestParam Long cursor) {
        PostListRes res = postService.getPostList(cursor);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(SuccessCode.POST_LIST_READ_SUCCESS, res));
    }
    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse<PostDetailRes>> getDetails(@PathVariable Long postId) {
        PostDetailRes res = postService.getPostDetail(postId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(SuccessCode.POST_DETAIL_READ_SUCCESS, res));
    }


    // -- U --
    @PatchMapping("/{postId}")
    public ResponseEntity<ApiResponse<PostUpdateRes>> patch(@PathVariable Long postId, /*@AuthenticationPrincipal UserDetails user,*/ @RequestBody PostUpdateReq req) {
        PostUpdateRes res = postService.updatePost(postId, req);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(SuccessCode.POST_UPDATE_SUCCESS, res));
    }


    // -- D --
    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse<PostDeleteRes>> delete(@PathVariable Long postId) {
        PostDeleteRes res = postService.deletePost(postId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(SuccessCode.POST_DELETE_SUCCESS, res));
    }
}
