package springboot.kakao_boot_camp.global.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {



     // 400 공통
    INVALID_REQUEST("INVALID_REQUEST", "잘못된 요청입니다."),


    //401 로그인
    AUTHENTICATION_FAILED("AUTHENTICATION_FAILED", "아이디 또는 비밀번호가 올바르지 않습니다."),


    // 409 회원가입
    DUPLICATE_EMAIL("DUPLICATE_EMAIL", "이미 존재하는 이메일입니다.");

    private final String code;
    private final String msg;


}
