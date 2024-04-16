package com.example.extension_block_system.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum BaseResponseCode {

    SUCCESS("S0001", HttpStatus.OK, "요청에 성공했습니다."),

    BAD_REQUEST("G0001", HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    NO_AUTHENTICATION("G0002", HttpStatus.FORBIDDEN, "접근 권한이 없습니다."),

    // extension
    EXTENSION_TYPE_NOT_FOUNT("E0001", HttpStatus.NOT_FOUND, "확장자 타입(고정 or 커스텀)을 찾을 수 없습니다."),
    NOT_EMPTY_EXTENSION_NAME("E0002", HttpStatus.BAD_REQUEST, "확장자 이름을 입력해주세요."),
    NOT_EMPTY_EXTENSION_TYPE("E0003", HttpStatus.BAD_REQUEST, "확장자 타입을 입력해주세요."),
    INVALID_EXTENSION_FORMAT("E0004", HttpStatus.BAD_REQUEST, "확장자 형식을 확인해주세요.");


    public final String code;
    public final HttpStatus status;
    public final String message;

    public static BaseResponseCode findByCode(String code) {
        return Arrays.stream(BaseResponseCode.values())
                .filter(b -> b.getCode().equals(code))
                .findAny().orElseThrow(() -> new BaseException(BAD_REQUEST));
    }

}
