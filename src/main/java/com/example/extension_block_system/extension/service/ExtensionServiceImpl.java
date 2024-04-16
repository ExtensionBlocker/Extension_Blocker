package com.example.extension_block_system.extension.service;

import com.example.extension_block_system.extension.dto.request.RegisterExtensionReq;
import com.example.extension_block_system.extension.entity.Extension;
import com.example.extension_block_system.extension.repository.ExtensionRepository;
import com.example.extension_block_system.global.exception.BaseException;
import com.example.extension_block_system.global.exception.BaseResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExtensionServiceImpl implements ExtensionService {

    private final ExtensionRepository extensionRepository;

    @Override
    @Transactional
    public void registerExtension(RegisterExtensionReq registerExtensionReq) {
        Boolean exists = extensionRepository.existsByNameAndIsEnable(registerExtensionReq.getName(), true);
        if(exists) throw new BaseException(BaseResponseCode.ALREADY_REGISTER_EXTENSION);
        extensionRepository.save(Extension.of(registerExtensionReq));
    }
}
