package springboot.kakao_boot_camp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.kakao_boot_camp.service.InitialService;

@RestController
public class InitialController {

    @Autowired
    private final InitialService initialService;

    InitialController(InitialService initialService){
        this.initialService=initialService;
    }

    @GetMapping("/hello")
    public String hello(){
        return initialService.getMessage();
    }

}
