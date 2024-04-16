package com.example.extension_block_system.extension.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegisterExtensionReq {

    @Schema(type = "String", description = "확장자 이름", example = "pdf", required = true)
    @Pattern(message = "E0004", regexp = "^[a-zA-Z]*$")
    @Size(max = 20, message = "E0006")
    @NotBlank(message = "E0002")
    private String name;

    @Schema(type = "String", description = "확장자 타입", example = "고정 or 커스텀", required = true)
    @NotBlank(message = "E0003")
    private String type;
}
