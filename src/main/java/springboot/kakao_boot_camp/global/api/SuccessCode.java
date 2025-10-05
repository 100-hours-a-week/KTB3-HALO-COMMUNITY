package springboot.kakao_boot_camp.global.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessCode {

    // -- Auth --
    REGISTER_SUCCESS(HttpStatus.CREATED, "REGISTER_SUCCESS", "회원가입을 성공하였습니다."),
    LOGIN_SUCCESS(HttpStatus.OK, "LOGIN_SUCCESS", "로그인에 성공했습니다"),

    // -- Perference --
    PREFERENCE_CREATED(HttpStatus.CREATED, "PREFERENCE_CREATED", "독서 취향 생성에 성공했습니다.");


    private final HttpStatus status;    // 상태 코드 번호
    private final String code;          // 상태 설명 (개발용)
    private final String message;       // 상태 설명 (사용자 친화적)




}
