package springboot.kakao_boot_camp.domain.post.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import springboot.kakao_boot_camp.domain.post.entity.Post;

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
    ){
        public static PostCreateRes from(Post post){
            return new PostCreateRes(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getImageUrl(),
            post.getCratedAt()
            );
        }
    }
    
    
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
    ){
        public static PostGetRes from(Post post){
            return new PostGetRes(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getImageUrl(),
            post.getLikeCount(),
            post.getViewCount(),
            post.getCommentCount(),
            post.getCratedAt(),
            post.getUpdatedAt()
            );
        }

    }

    // -- U --
    public record PostUpdateReq(
            String title,
            String content,
            String imageUrl
    ){}
    public record PostUpdateRes(            // 수정하고 바로 화면에 반영하기 위해 전체 정보 내려줌
            Long postId,
            String title,
            String content,
            String imageUrl,

            int likeCount,
            int viewCount,
            int commentCount,

            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ){
        public static PostUpdateRes from(Post post){
            return new PostUpdateRes(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getImageUrl(),
            post.getLikeCount(),
            post.getViewCount(),
            post.getCommentCount(),
            post.getCratedAt(),
            post.getUpdatedAt()
            );
        }
    }

    // -- D --
    
}
