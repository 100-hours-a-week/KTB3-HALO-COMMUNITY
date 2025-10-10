package springboot.kakao_boot_camp.domain.auth.dto;

import jakarta.validation.constraints.Email;
import lombok.NonNull;
import springboot.kakao_boot_camp.domain.user.entity.User;

public class AuthDtos {


    // 1. Sign Up
    public record SignReq(
            @Email
            @NonNull
            String email,

            @NonNull
            String passWord,

            String nickName,

            String profileImage
    ) {
    }

    public record SignRes(
            long id
    ) {

    }

    // 2. Todo : login

    public record LoginReq(
            String email,
            String passWord
    ) {
    }

    public record LoginRes(
            Long userId,
            String email,
            String nickName,
            String accessToken
    ) {
        public static LoginRes from(User user, String accessToken) {
            return new LoginRes(
                    user.getId(),
                    user.getEmail(),
                    user.getNickName(),
                    accessToken
            );

        }
    }
}
