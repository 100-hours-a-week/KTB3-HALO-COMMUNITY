package springboot.kakao_boot_camp.domain.auth.exception;

import springboot.kakao_boot_camp.global.api.ErrorCode;
import springboot.kakao_boot_camp.global.exception.BusinessException;


// 401
public class InvalidLoginException extends BusinessException {
    public InvalidLoginException(ErrorCode errorCode) {
        super(status, errorCode, message);
    }
}
