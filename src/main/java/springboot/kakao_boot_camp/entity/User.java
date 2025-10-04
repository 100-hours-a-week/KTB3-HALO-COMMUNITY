package springboot.kakao_boot_camp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickName;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Post> posts;       // 명시적인 형태

    @CreatedDate
    LocalDateTime cratedAt;

    LocalDateTime updatedAt;

    LocalDateTime deletedAt;

}
