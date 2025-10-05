package springboot.kakao_boot_camp.global.exception.custom;


import lombok.Getter;
import lombok.Setter;
import springboot.kakao_boot_camp.global.api.ErrorCode;


@Getter
@Setter
public class DuplicateResourceException extends RuntimeException{
        ErrorCode errorCode;

    public DuplicateResourceException(ErrorCode errorCode){
        super(errorCode.getMsg()); // Throwable의 detailMessage에 message 저장
    }
}
