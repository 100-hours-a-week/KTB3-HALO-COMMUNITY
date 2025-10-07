package springboot.kakao_boot_camp.domain.auth.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.kakao_boot_camp.domain.auth.dto.AuthDtos.*;
import springboot.kakao_boot_camp.domain.user.entity.User;
import springboot.kakao_boot_camp.global.api.ErrorCode;
import springboot.kakao_boot_camp.global.constant.DefaultImage;
import springboot.kakao_boot_camp.global.exception.DuplicateResourceException;
import springboot.kakao_boot_camp.domain.user.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;


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


        // 2. User 객체 생성
        String encodedPassWord = passwordEncoder.encode(req.passWord());
        User user = new User(req.email(), encodedPassWord, req.nickName(), req.profileImage());


        // 3. DB에 저장
        User savedUSer = userRepo.save(user);

        // 4. Sign Response DTO 반환
        return new SignRes(savedUSer.getId());

    }
}
