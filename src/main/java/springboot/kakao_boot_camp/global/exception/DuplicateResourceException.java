package springboot.kakao_boot_camp.global.exception;


import lombok.Getter;
import lombok.Setter;
import springboot.kakao_boot_camp.global.api.ErrorCode;


@Getter
@Setter
public class DuplicateResourceException extends BusinessException{
        ErrorCode errorCode;

    public DuplicateResourceException(ErrorCode errorCode){
        super(ErrorCode.DUPLICATE_EMAIL); // Throwable의 detailMessage에 message 저장
    }
}
