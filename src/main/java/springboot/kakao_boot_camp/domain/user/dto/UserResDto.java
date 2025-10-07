package springboot.kakao_boot_camp.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import springboot.kakao_boot_camp.domain.user.entity.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserResDto {
    private List<User> users;
}
