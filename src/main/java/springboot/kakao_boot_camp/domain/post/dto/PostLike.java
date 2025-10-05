package springboot.kakao_boot_camp.domain.post.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import springboot.kakao_boot_camp.domain.user.dto.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    LocalDateTime createdAt;

    // 좋아요는 수정 시각이 필요가 없음

}
