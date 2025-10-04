package springboot.kakao_boot_camp.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class InitialService {       // 비즈니스 로직

    @Bean
    public String getMessage(){
        return "Hello";
    }
}
