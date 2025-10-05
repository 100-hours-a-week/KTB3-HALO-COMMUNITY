package springboot.kakao_boot_camp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.kakao_boot_camp.dto.AuthDtos.*;
import springboot.kakao_boot_camp.entity.User;
import springboot.kakao_boot_camp.global.api.ErrorCode;
import springboot.kakao_boot_camp.global.exception.custom.DuplicateResourceException;
import springboot.kakao_boot_camp.repository.user.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@RequiredArgsConstructor
public class AuthService {      //Dto로 컨트롤러에서 받음

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public SignRes signUp(SignReq req) throws RuntimeException {


        // 1. 중복 확인
        if (!userRepo.existsAllByEmail(req.email())) {
            throw new DuplicateResourceException(ErrorCode.DUPLICATE_EMAIL);
        }

        // 2. User Table에 새로운 정보 저장
        User user = User.createNormalUser(req.email(), passwordEncoder.encode(req.passWord()), req.nickName(), req.profileImage());
        userRepo.save(user);




        return null;

    }
}
