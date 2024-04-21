package com.example.extension_block_system.extension.dto.response;

import com.example.extension_block_system.extension.entity.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FixedExtensionRes {

    @Schema(type = "List<String>", description = "고정 확장자 리스트", example = "bat, cmd, com ...")
    private List<String> name;

    public static FixedExtensionRes toDto(List<Extension> fixedExtension) {
        return FixedExtensionRes.builder()
                .name(fixedExtension.stream().map(Extension::getName).collect(Collectors.toList()))
                .build();
    }
}
