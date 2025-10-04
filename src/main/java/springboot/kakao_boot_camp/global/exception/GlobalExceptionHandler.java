package springboot.kakao_boot_camp.global.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springboot.kakao_boot_camp.global.api.ApiResponse;
import springboot.kakao_boot_camp.global.exception.custom.DuplicateResourceException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Void>> hanlderDuplicateResource(DuplicateResourceException e){
        return  ResponseEntity
                .status(HttpStatus)
                .body(ApiResponse.clientError())
    }

}
