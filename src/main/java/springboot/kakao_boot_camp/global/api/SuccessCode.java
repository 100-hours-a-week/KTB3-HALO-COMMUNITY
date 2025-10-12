package springboot.kakao_boot_camp.global.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessCode {

    // -- Auth --
    REGISTER_SUCCESS(HttpStatus.OK, "회원가입을 성공하였습니다."),
    LOGIN_SUCCESS(HttpStatus.OK, "로그인에 성공했습니다"),

    // -- User --
    GET_USERS_SUCCESS(HttpStatus.OK, "사용자 목록 조회를 성공하였습니다."),

    // -- Post --
    POST_DETAIL_READ_SUCCESS(HttpStatus.OK, "게시글 조회를 성공하였습니다."),
    POST_LIST_READ_SUCCESS(HttpStatus.OK, "게시글 목록을 성공적으로 조회하였습니다."),

    POST_CREATE_SUCCESS(HttpStatus.CREATED, "게시글을 성공적으로 등록하였습니다."),

    POST_UPDATE_SUCCESS(HttpStatus.OK, "게시글을 성공적으로 수정하였습니다."),

    POST_DELETE_SUCCESS(HttpStatus.OK, "게시글을 성공적으로 삭제하였습니다.");


    private final HttpStatus status;
    private final String message;       // 상태 설명 (사용자 친화적)
}
