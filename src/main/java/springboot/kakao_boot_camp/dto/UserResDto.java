package springboot.kakao_boot_camp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import springboot.kakao_boot_camp.entity.Post;
import springboot.kakao_boot_camp.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserResDto {
    private List<User> users;
}
