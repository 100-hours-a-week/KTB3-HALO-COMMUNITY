package springboot.kakao_boot_camp.domain.comment.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import springboot.kakao_boot_camp.domain.post.dto.Post;
import springboot.kakao_boot_camp.domain.user.dto.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    // Todo
    // [Content]
    // size <= 1000
    @Size(max = 1000)
    private String content;



    // Todo
    //  [createtime]
    private LocalDateTime createdAt;


    // Todo
    // [updatedTime]
    private LocalDateTime updatedAt;

}
