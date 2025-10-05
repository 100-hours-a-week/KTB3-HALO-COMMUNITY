package springboot.kakao_boot_camp.global.exception.handler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springboot.kakao_boot_camp.domain.auth.exception.InvalidLoginException;
import springboot.kakao_boot_camp.global.api.*;
import springboot.kakao_boot_camp.global.exception.DuplicateResourceException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //409
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Void>> hanlderDuplicateResource(DuplicateResourceException e){
        return  ResponseEntity
                .status(HttpStatus.CONFLICT)                                    // 409
                .body(ApiResponse.clientError(ErrorCode.DUPLICATE_EMAIL));        // code : DUPLICATE_EMAIL, message : 이미 존재하는 이메일입니다
    }


    // 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(MethodArgumentNotValidException e) {
        // 여러 필드 중 첫 번째 에러만 가져오기 (필요하면 전체 리스트로 가공 가능)
        String errorMessage = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(fieldError -> fieldError.getDefaultMessage())   // DTO의 @Email(message="...") 내용
                .orElse("잘못된 요청입니다.");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)   // 400
                .body(ApiResponse.clientError(ErrorCode.INVALID_REQUEST, errorMessage));
    }

    // 로그인 실패(자격 증명 실패) → 401
    @ExceptionHandler(InvalidLoginException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidLogin(InvalidLoginException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.clientError(ErrorCode.AUTHENTICATION_FAILED, e.getMessage()));
    }

}
