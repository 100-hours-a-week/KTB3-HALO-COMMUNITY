package springboot.kakao_boot_camp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
@Getter
@Setter
@AllArgsConstructor
public class AuthReqDto {
    private String email;
    private String passWord;
    private String nickName;
    private String profileImageUrl;
}
