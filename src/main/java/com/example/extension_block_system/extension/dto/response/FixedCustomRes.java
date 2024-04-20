package com.example.extension_block_system.extension.dto.response;

import com.example.extension_block_system.extension.entity.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FixedCustomRes {

    @Schema(type = "List<String>", description = "고정 확장자 리스트", example = "bat, cmd, com ...")
    private List<String> name;

    public static FixedCustomRes toDto(List<Extension> fixedCustoms) {
        return FixedCustomRes.builder()
                .name(fixedCustoms.stream().map(Extension::getName).collect(Collectors.toList()))
                .build();
    }
}
