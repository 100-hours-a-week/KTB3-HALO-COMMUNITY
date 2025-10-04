package springboot.kakao_boot_camp.global.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> ok(String message, T data){        // <T>를 반환 타입 앞에 써주는 이유 : 컴파일시 해당 메서드의 반환 타입을 알기 위해서, 런타임시 파라미터로 들어온 T를 static 상황(컴파일 상황)에서는 모르기 때문이다. 컴퓨일이 런타임 이전에 일어나기 때문에
        return new ApiResponse<T>(200, message, data);
    }

    public static <T> ApiResponse<T> clientError(int code,String message){
            return new ApiResponse<T>(code, message,null);
    }

    public static <T> ApiResponse<T> serverError(int code, String message){
            return new ApiResponse<T>(code, message,null);
    }
}
