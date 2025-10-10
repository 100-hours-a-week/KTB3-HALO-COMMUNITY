package springboot.kakao_boot_camp.domain.post.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.kakao_boot_camp.domain.post.Service.PostService;
import springboot.kakao_boot_camp.domain.post.dto.PostDtos.*;
import springboot.kakao_boot_camp.global.api.ApiResponse;
import springboot.kakao_boot_camp.global.api.SuccessCode;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;
    // 학습용이라 @RequiredArgsConstructor 안씀
    public PostController(PostService postService) {
        this.postService = postService;
    }




    // -- Get --

    //1. 전체 게시글
    @GetMapping
    public ResponseEntity<ApiResponse<PostListRes>> getList(@RequestParam Long cursor) {
        PostListRes res = postService.getPostList(cursor);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(SuccessCode.POST_LIST_READ_SUCCESS, res));
    }
    //2. 특정 게시글 요청 ( 구현 & 동작 이상 무)
    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse<PostDetailRes>> getDetails(@PathVariable Long postId) {
        PostDetailRes res = postService.getPostDetail(postId);

        return ResponseEntity.status(HttpStatus.OK)      // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_READ_SUCCESS, res));
    }


    // -- Post --
    @PostMapping
    public ResponseEntity<ApiResponse<PostCreateRes>> create(@RequestBody @Valid PostCreateReq req) {
        PostCreateRes res = postService.createPost(req);

        return ResponseEntity.status(HttpStatus.CREATED)      // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_CREATE_SUCCESS, res));
    }


    // -- Update : Patch --
    @PatchMapping
    public ResponseEntity<ApiResponse<PostUpdateRes>> update(@PathVariable Long postId, /*@AuthenticationPrincipal UserDetails user,*/ @RequestBody PostUpdateReq req) {
        PostUpdateRes res = postService.updatePost(postId, req);

        return ResponseEntity.status(HttpStatus.OK)      // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_UPDATE_SUCCESS, res));
    }


    // -- Delete --
    @DeleteMapping
    public ResponseEntity<ApiResponse<PostDeleteRes>> delete(@PathVariable Long postId) {
        PostDeleteRes res = postService.deletePost(postId);
        return ResponseEntity.status(HttpStatus.OK)   // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_DELETE_SUCCESS, res));
    }
}
