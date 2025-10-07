package springboot.kakao_boot_camp.domain.post.controller;

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

    @GetMapping
    public ResponseEntity<ApiResponse<PostRes>> getPost(@PathVariable Long postId){
        PostRes postRes= postService.getPost(postId);

        return ResponseEntity
                .status(HttpStatus.OK)      // StateLine에 200 전송
                .body(ApiResponse.success(SuccessCode.POST_CREATE_SUCCESS, postRes));
    }



//    @PostMapping


//    @PutMapping


//    @DeleteMapping


}
