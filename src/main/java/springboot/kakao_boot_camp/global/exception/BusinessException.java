package springboot.kakao_boot_camp.global.exception;

import lombok.Getter;
import springboot.kakao_boot_camp.global.api.ErrorCode;

@Getter
public class BusinessException extends RuntimeException{
    ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());  // 나중에 로그 확인을 위해 런타임 예외 디테일 message 에 저장
        this.errorCode=errorCode;
    }
}
