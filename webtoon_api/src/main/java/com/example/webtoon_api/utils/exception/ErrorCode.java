package com.example.webtoon_api.utils.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /* 401 UNAUTHORIZED : 클라이언트가 요청한 리소스에 대한 인증 정보가 없거나 잘못된 경우 */
    INVALID_CLIENT_TOKEN(UNAUTHORIZED, "유효하지 않은 클라이언트 토큰입니다."),

    /* 403 FORBIDDN : 클라이언트가 요청한 리소스에 대한 권한이 없는 경우 */
    FORBIDDEN_USER(FORBIDDEN, "권한이 없는 요청입니다."),

    /* 404 NOT_FOUND : 해당하는 DATA를 찾을 수 없음 */
    USER_NOT_FOUND(NOT_FOUND, "해당 사용자 정보를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
