package springboot.kakao_boot_camp.global.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {


    // -- Auth
    // 1. 회원가입
    INVALID_REQUEST(400,  "잘못된 요청입니다."),   // 400
    DUPLICATE_EMAIL(409,  "중복된 이메일 입니다."), // 409 회원가입


    // 2. 로그인
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED.value(), "아이디 또는 비밀번호가 잘 못 되었습니다.") ,    // 계정 존재 여부를 숨기기 때문에 401이 맞다





    // -- User --

    // -- Post --
    POST_NOT_FOUND(404, "해당 게시글을 찾을 수 없습니다.");


    private final int status;
    private final String message;


}
