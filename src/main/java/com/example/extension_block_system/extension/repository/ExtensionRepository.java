package com.example.extension_block_system.extension.repository;

import com.example.extension_block_system.extension.entity.Extension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExtensionRepository extends JpaRepository<Extension, Long> {
    Optional<Extension> findByNameAndIsEnable(String name, Boolean isEnable);

    Boolean existsByNameAndIsEnable(String name, Boolean isEnable);
}
