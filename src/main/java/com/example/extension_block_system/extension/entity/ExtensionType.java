package com.example.extension_block_system.extension.entity;

import com.example.extension_block_system.global.exception.BaseException;
import com.example.extension_block_system.global.exception.BaseResponseCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ExtensionType {
    CUSTOM("커스텀"),
    FIX("고정");
    private final String value;

    public static ExtensionType getRoleByName(String value) {
        return Arrays.stream(ExtensionType.values())
                .filter(r -> r.getValue().equals(value))
                .findAny().orElseThrow(() -> new BaseException(BaseResponseCode.EXTENSION_TYPE_NOT_FOUNT));
    }
}
