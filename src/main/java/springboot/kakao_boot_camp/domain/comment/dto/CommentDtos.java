package springboot.kakao_boot_camp.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import springboot.kakao_boot_camp.domain.comment.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

public class CommentDtos {

    // -- C --
    public record CommentCreateReq(
            @NotBlank(message = "댓글 내용은 비워둘 수 없습니다.")
            @Size(max = 1000, message = "댓글은 최대 1000자까지 입력 가능합니다.")
            String content
    ) {
    }
    public record CommentCreateRes(
            Long commentId
    ) {
        public static CommentCreateRes from(Comment comment) {
            return new CommentCreateRes(
                    comment.getId()
            );
        }
    }
}
