package com.example.extension_block_system.extension.dto.response;

import com.example.extension_block_system.extension.entity.Extension;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomExtension {

    @Schema(type = "Long", description = "확장자 id", example = "1")
    private Long extensionId;

    @Schema(type = "String", description = "확장자 이름", example = "pdf")
    @NotBlank(message = "E0002")
    private String name;

    public static CustomExtension toDto(Extension extension) {
        return CustomExtension.builder()
                .extensionId(extension.getExtensionId())
                .name(extension.getName())
                .build();
    }
}
