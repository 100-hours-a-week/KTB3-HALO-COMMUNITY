package springboot.kakao_boot_camp.domain.post.exception;

import springboot.kakao_boot_camp.global.api.ErrorCode;
import springboot.kakao_boot_camp.global.exception.BusinessException;

public class PostNotFoundException extends BusinessException {
    public PostNotFoundException(){
        super(ErrorCode.POST_NOT_FOUND);
    }

}
