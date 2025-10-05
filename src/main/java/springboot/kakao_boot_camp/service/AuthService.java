package springboot.kakao_boot_camp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.kakao_boot_camp.dto.AuthDtos.*;
import springboot.kakao_boot_camp.global.api.ErrorCode;
import springboot.kakao_boot_camp.global.exception.custom.DuplicateResourceException;
import springboot.kakao_boot_camp.repository.user.UserRepo;

@Service
@RequiredArgsConstructor
public class AuthService {      //Dto로 컨트롤러에서 받음

    private final UserRepo userRepo;

    public SignRes signUp(SignReq req) throws RuntimeException {


        // 1. 중복 확인
        if (!userRepo.existsAllByEmail(req.email())) {
            throw new DuplicateResourceException(ErrorCode.DUPLICATE_EMAIL);
        }

        // 2.

        return null;

    }
}
