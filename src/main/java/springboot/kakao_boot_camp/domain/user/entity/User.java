package springboot.kakao_boot_camp.domain.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import springboot.kakao_boot_camp.domain.post.entity.Post;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    @Column(nullable = false)
    @Email(message = "올바른 이메일 형식을 입력해주세요.")
    private String email;

    @Column(nullable = false)
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상, 20자 이하이며, 대문자, 소문자, 숫자 그리고 특수문자를 각각 최소 1개 포함해야 합니다.")
    private String passWord;

    @Column(nullable = false)
    @Size(min = 2, max = 10, message = "닉네임은 2~10자여야 합니다.")
    private String nickName;

    @Column(nullable = false)
    @NotBlank(message = "프로필 사진을 추가해주세요.")
    private String profileImage;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Post> posts;       // 명시적인 형태

    @CreatedDate
    LocalDateTime cratedAt;

    LocalDateTime updatedAt;

    LocalDateTime deletedAt;


    public User(String email, String passWord, String nickName, String profileImage) {
        this.email = email;
        this.passWord = passWord;
        this.nickName = nickName;
        this.profileImage = profileImage;
    }

    public User() {

    }
}
