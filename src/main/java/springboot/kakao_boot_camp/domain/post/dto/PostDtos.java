package springboot.kakao_boot_camp.domain.post.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class PostDtos {
    
    // -- C ==
    public record PostCreateReq(
            @NotBlank(message = "제목이 비었습니다.")
            String title,

            @NotBlank(message = "내용이 비었습니다.")
            String content,

            String imageUrl
    ){}
    public record PostCreateRes(
            Long postId,
            String title,
            String content,
            String imageUrl,

            LocalDateTime createdAt
    ){}
    
    
    // -- R -- 
    public record PostGetReq(
            @NotBlank(message = "제목이 비었습니다.")
            String title,

            @NotBlank(message = "내용이 비었습니다.")
            String content,

            String imageUrl
    ){}
    public record PostGetRes(
            Long postId,
            String title,
            String content,
            String imageUrl,

            int likeCount,
            int viewCount,
            int commentCount,

            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ){}
    
}
