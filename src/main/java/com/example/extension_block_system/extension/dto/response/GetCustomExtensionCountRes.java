package com.example.extension_block_system.extension.dto.response;

import com.example.extension_block_system.global.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCustomExtensionCountRes {

    @Schema(type = "Integer", description = "커스텀 확장자 최대 개수", example = "200")
    private Integer maxCount;
    @Schema(type = "Integer", description = "현재 커스텀 확장자 개수", example = "1")
    private Integer customExtensionCount;

    public static GetCustomExtensionCountRes toDto(Integer count) {
        return GetCustomExtensionCountRes.builder()
                .maxCount(Constants.Extension.SAVE_MAX_SIZE)
                .customExtensionCount(count)
                .build();
    }
}
