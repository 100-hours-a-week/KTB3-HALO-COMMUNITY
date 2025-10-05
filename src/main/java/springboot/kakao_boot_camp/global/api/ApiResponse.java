package springboot.kakao_boot_camp.global.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {
    private String code;    // ex. DUPLICATE_EMIAL          (개발용 친화)
    private String message; // ex. 이미 존재하는 이메일입니다.    (사람용 친화)
    private T data;

    public static <T> ApiResponse<T> ok(String code,String message, T data){        // <T>를 반환 타입 앞에 써주는 이유 : 컴파일시 해당 메서드의 반환 타입을 알기 위해서, 런타임시 파라미터로 들어온 T를 static 상황(컴파일 상황)에서는 모르기 때문이다. 컴퓨일이 런타임 이전에 일어나기 때문에
        return new ApiResponse<T>(code, message, data);
    }

    public static <T> ApiResponse<T> clientError(ErrorCode errorCode){
            return new ApiResponse<T>(errorCode.getCode(), errorCode.getMsg(),null);
    }

    public static <T> ApiResponse<T> serverError(ErrorCode errorCode){
            return new ApiResponse<T>(errorCode.getCode(), errorCode.getMsg(),null);
    }
}
