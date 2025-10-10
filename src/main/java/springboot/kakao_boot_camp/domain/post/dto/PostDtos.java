package springboot.kakao_boot_camp.domain.post.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import springboot.kakao_boot_camp.domain.post.entity.Post;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

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

    // 1. List
    public record PostListRes(
        List<PostSummary> posts,
        PageInfo pageInfo
    ) {
        public static PostListRes of(List<PostSummary> posts, PageInfo pageInfo) {
            return new PostListRes(posts, pageInfo);
        }

        // 📝 게시글 요약 정보
        public record PostSummary(
                Long postId,
                String title,
                String nickname,
                String profileImageUrl,
                int likeCount,
                int commentCount,
                int viewCount,
                LocalDateTime createdAt,
                LocalDateTime updatedAt
        ) {
            public static PostSummary of(
                    Long postId,
                    String title,
                    String nickname,
                    String profileImageUrl,
                    int likeCount,
                    int commentCount,
                    int viewCount,
                    LocalDateTime createdAt,
                    LocalDateTime updatedAt
            ) {
                return new PostSummary(
                        postId,
                        title,
                        nickname,
                        profileImageUrl,
                        likeCount,
                        commentCount,
                        viewCount,
                        createdAt,
                        updatedAt
                );
            }
        }

        // 🧭 페이지 정보
        public record PageInfo(
                boolean hasNext,
                Long nextCursor,
                int size
        ) {
            public static PageInfo of(boolean hasNext, Long nextCursor, int size) {
                return new PageInfo(hasNext, nextCursor, size);
            }
        }

    }
    // 2. Detail
    public record PostDetailRes(
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
        public static PostDetailRes from(Post post){
            return new PostDetailRes(
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
    public record PostDeleteReq(){}
    public record PostDeleteRes(
            Long id,
//            boolean deleted,        // 추후 soft 삭제 시 사용
            LocalDateTime deletedAt
    ){
        public static PostDeleteRes from(Long id, /*boolean deleted,*/ LocalDateTime deletedAt){
            return new PostDeleteRes(id, /*deleted,*/ deletedAt);
        }
    }
    
}
