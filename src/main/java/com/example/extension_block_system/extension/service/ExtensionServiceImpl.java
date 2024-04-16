package com.example.extension_block_system.extension.service;

import com.example.extension_block_system.extension.dto.request.RegisterExtensionReq;
import com.example.extension_block_system.extension.dto.response.GetCustomExtensionRes;
import com.example.extension_block_system.extension.entity.Extension;
import com.example.extension_block_system.extension.entity.ExtensionType;
import com.example.extension_block_system.extension.repository.ExtensionRepository;
import com.example.extension_block_system.global.Constants;
import com.example.extension_block_system.global.exception.BaseException;
import com.example.extension_block_system.global.exception.BaseResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExtensionServiceImpl implements ExtensionService {

    private final ExtensionRepository extensionRepository;

    @Override
    @Transactional
    public void registerExtension(RegisterExtensionReq registerExtensionReq) {

        // 커스텀 확장자 최대 등록 개수 체크
        if (ExtensionType.getRoleByName(registerExtensionReq.getType()).equals(ExtensionType.CUSTOM)) {
            if(extensionRepository.countByTypeAndIsEnable(ExtensionType.CUSTOM, true) >= Constants.Extension.SAVE_MAX_SIZE)
                throw new BaseException(BaseResponseCode.SAVE_EXTENSION_MAX_SIZE_OVER);
        }
        // 확장자 중복 체크
        Boolean exists = extensionRepository.existsByNameAndIsEnable(registerExtensionReq.getName(), true);
        if(exists) throw new BaseException(BaseResponseCode.ALREADY_REGISTER_EXTENSION);
        extensionRepository.save(Extension.of(registerExtensionReq));
    }

    @Override
    public GetCustomExtensionRes getCustomExtension() {
        return GetCustomExtensionRes.toDto(extensionRepository.findByTypeAndIsEnable(ExtensionType.CUSTOM, true));
    }

    @Override
    @Transactional
    public void removeCustomExtension(Long extensionId) {
        Extension extension = extensionRepository.findByExtensionIdAndIsEnable(extensionId, true).orElseThrow(() -> new BaseException(BaseResponseCode.EXTENSION_NOT_FOUND));
        extension.remove();
    }
}
