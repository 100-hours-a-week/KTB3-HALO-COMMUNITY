package springboot.kakao_boot_camp.dto;

import jakarta.validation.constraints.Email;
import lombok.NonNull;

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
}
