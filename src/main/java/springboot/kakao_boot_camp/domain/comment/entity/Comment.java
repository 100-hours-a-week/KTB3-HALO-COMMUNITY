package springboot.kakao_boot_camp.domain.comment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import springboot.kakao_boot_camp.domain.post.entity.Post;
import springboot.kakao_boot_camp.domain.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "comment")
@Builder
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 1000)
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Comment() {
    }
}

