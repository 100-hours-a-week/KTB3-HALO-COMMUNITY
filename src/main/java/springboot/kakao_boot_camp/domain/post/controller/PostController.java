package springboot.kakao_boot_camp.domain.post.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.kakao_boot_camp.domain.post.Service.PostService;
import springboot.kakao_boot_camp.domain.post.dto.PostDtos.*;
import springboot.kakao_boot_camp.global.api.ApiResponse;
import springboot.kakao_boot_camp.global.api.SuccessCode;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;


    // 학습용이라 @RequiredArgsConstructor 안씀
    public PostController(PostService postService){
        this.postService=postService;
    }


    // -- Get --
    @GetMapping
    public ResponseEntity<ApiResponse<PostGetRes>> get(@PathVariable Long postId){
        PostGetRes res= postService.getPost(postId);

        return ResponseEntity
                .status(HttpStatus.OK)      // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_READ_SUCCESS, res));
    }


    // -- Post --
    @PostMapping
    public ResponseEntity<ApiResponse<PostCreateRes>> create(@RequestBody @Valid PostCreateReq req) {
        PostCreateRes res = postService.createPost(req);

        return ResponseEntity
                .status(HttpStatus.CREATED)      // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_CREATE_SUCCESS, res));
    }



    // -- Get --
    // 1. Patch 사용 이유 : 게시글의 부분 수정일 경우를 고려하여 Patch를 사용하였습니다.
    // 2. Put을 만들지 않은 이유 : 모두 수정되었을 경우, Patch로도 충분히 구현 가능하기 때문입니다.
    @PatchMapping
    public ResponseEntity<ApiResponse<PostUpdateRes>> update(@PathVariable Long postId, @RequestBody PostUpdateReq req) {
        PostUpdateRes postRes = postService.updatePost(postId, req);
        return ResponseEntity
                .status(HttpStatus.OK)      // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_UPDATE_SUCCESS, postRes));
    }




    @DeleteMapping
    public ResponseEntity<ApiResponse<PostGetRes>> update(@RequestBody PostGetReq req) {
        PostGetRes postRes = postService.deletePost(req);
        return ResponseEntity
                .status(HttpStatus.OK)      // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_UPDATE_SUCCESS, postRes));
    }


}
