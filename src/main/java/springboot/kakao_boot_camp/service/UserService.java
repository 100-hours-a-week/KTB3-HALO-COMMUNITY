package springboot.kakao_boot_camp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.kakao_boot_camp.entity.User;
import springboot.kakao_boot_camp.repository.user.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepo postRepo;

    public List<User> getUsers() {
        return postRepo.getUsers();
    }
}
