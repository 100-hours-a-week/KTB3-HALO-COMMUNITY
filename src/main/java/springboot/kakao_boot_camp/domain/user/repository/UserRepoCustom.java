package springboot.kakao_boot_camp.domain.user.repository;

import org.springframework.stereotype.Repository;
import springboot.kakao_boot_camp.domain.user.entity.User;

import java.util.List;

@Repository
public interface UserRepoCustom {
    public List<User> getUsers();
}
