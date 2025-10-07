package springboot.kakao_boot_camp.domain.post.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PostDtos {

    public record PostReq(
            @NotBlank(message = "제목이 비었습니다.")
            String title,

            @NotBlank(message = "내용이 비었습니다.")
            String content,

            String imageUrl
    ){}
    public record PostRes(
            
    ){}
}
