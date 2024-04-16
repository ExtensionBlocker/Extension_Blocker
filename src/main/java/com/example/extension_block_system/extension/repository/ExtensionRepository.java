package com.example.extension_block_system.extension.repository;

import com.example.extension_block_system.extension.entity.Extension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionRepository extends JpaRepository<Extension, Long> {
}
