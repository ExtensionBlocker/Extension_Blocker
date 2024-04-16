package com.example.extension_block_system.extension.repository;

import com.example.extension_block_system.extension.entity.Extension;
import com.example.extension_block_system.extension.entity.ExtensionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExtensionRepository extends JpaRepository<Extension, Long> {
    Boolean existsByNameAndIsEnable(String name, Boolean isEnable);

    List<Extension> findByTypeAndIsEnable(ExtensionType type, Boolean isEnable);

    Optional<Extension> findByExtensionIdAndIsEnable(Long extensionId, Boolean isEnable);
}
