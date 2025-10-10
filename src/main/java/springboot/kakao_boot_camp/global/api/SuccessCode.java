package springboot.kakao_boot_camp.global.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessCode {

    // -- Auth --
    REGISTER_SUCCESS(HttpStatus.CREATED.value(),  "회원가입을 성공하였습니다."),
    LOGIN_SUCCESS(HttpStatus.OK.value(),  "로그인에 성공했습니다"),

    // -- User --

    // -- Post --
    POST_CREATE_SUCCESS(HttpStatus.CREATED.value()  ,  "게시글을 성공적으로 등록하였습니다."),
    POST_READ_SUCCESS(HttpStatus.OK.value(), "게시글 조회를 성공하였습니다."),
    POST_UPDATE_SUCCESS(HttpStatus.OK.value(),  "게시글을 성공적으로 수정하였습니다."),
    POST_DELETE_SUCCESS(HttpStatus.OK.value(),  "게시글을 성공적으로 삭제하였습니다.");


    private int status;    // 상태 코드 번호
    private final String message;       // 상태 설명 (사용자 친화적)
}
