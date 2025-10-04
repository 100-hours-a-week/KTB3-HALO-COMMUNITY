package springboot.kakao_boot_camp.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.kakao_boot_camp.entity.User;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User,Long>, UserRepoCustom {
    Optional<User> findByEmail(String email);
    boolean existsAllByEmail(String email);
}
