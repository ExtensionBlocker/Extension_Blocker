package com.example.extension_block_system.extension.entity;

import com.example.extension_block_system.extension.dto.request.RegisterExtensionReq;
import com.example.extension_block_system.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Extension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extensionId;

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private ExtensionType type;

    @Builder
    public Extension(Long extensionId, String name, ExtensionType type) {
        this.extensionId = extensionId;
        this.name = name;
        this.type = type;
    }

    public static Extension of(RegisterExtensionReq registerExtensionReq) {
        return Extension.builder()
                .name(registerExtensionReq.getName())
                .type(ExtensionType.getRoleByName(registerExtensionReq.getType()))
                .build();
    }

    public void remove() {
        setIsEnable(false);
    }
}
