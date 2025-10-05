package springboot.kakao_boot_camp.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.kakao_boot_camp.entity.User;
import springboot.kakao_boot_camp.domain.user.repository.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepo postRepo;

    public List<User> getUsers() {
        return postRepo.getUsers();
    }
}
