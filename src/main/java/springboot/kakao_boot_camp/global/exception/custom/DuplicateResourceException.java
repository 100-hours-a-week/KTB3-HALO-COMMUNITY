package springboot.kakao_boot_camp.global.exception.custom;


import lombok.extern.slf4j.Slf4j;


public class DuplicateResourceException extends RuntimeException{
    public DuplicateResourceException(String message){
        super(message); // Throwable의 detailMessage에 message 저장
    }
}
