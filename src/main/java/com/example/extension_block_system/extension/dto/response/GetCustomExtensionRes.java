package com.example.extension_block_system.extension.dto.response;

import com.example.extension_block_system.extension.entity.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
public class GetCustomExtensionRes {

    @Schema(type = "List<String>", description = "커스텀 확장자 목록 리스트", example = "[{extensionId : 1, name : jpg}, {extensionId : 2, name : png}]")
    List<CustomExtension> customExtensionList;

    public static GetCustomExtensionRes toDto(List<Extension> customExtensions) {
        return GetCustomExtensionRes.builder()
                .customExtensionList(customExtensions.stream().map(CustomExtension::toDto).collect(Collectors.toList()))
                .build();
    }
}
