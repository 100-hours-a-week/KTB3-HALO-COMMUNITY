package springboot.kakao_boot_camp.global.exception;

import lombok.Getter;
import springboot.kakao_boot_camp.global.api.ErrorCode;

@Getter
public class BusinessException extends RuntimeException{
    ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode=errorCode;
    }
}
