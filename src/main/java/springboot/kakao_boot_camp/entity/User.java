package springboot.kakao_boot_camp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
    @Email(message = "올바른 이메일 형식이여야 합니다.")
    private String email;

    @Column(nullable = false)
    @Size(min = 8, max = 20, message = "비밀번호는 8~20자여야 합니다.")
    private String password;

    @Column(nullable = false)
    @Size(min = 2, max = 10, message = "닉네임은 2~10자여야 합니다.")
    private String nickName;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Post> posts;       // 명시적인 형태

    @CreatedDate
    LocalDateTime cratedAt;

    LocalDateTime updatedAt;

    LocalDateTime deletedAt;

}
