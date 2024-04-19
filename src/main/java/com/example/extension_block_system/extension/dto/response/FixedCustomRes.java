package com.example.extension_block_system.extension.dto.response;

import com.example.extension_block_system.extension.entity.Extension;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FixedCustomRes {

    private List<String> name;

    public static FixedCustomRes toDto(List<Extension> fixedCustoms) {
        return FixedCustomRes.builder()
                .name(fixedCustoms.stream().map(Extension::getName).collect(Collectors.toList()))
                .build();
    }
}
