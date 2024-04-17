package com.example.extension_block_system.extension.service;

import com.example.extension_block_system.extension.dto.request.RegisterExtensionReq;
import com.example.extension_block_system.extension.dto.response.GetCustomExtensionCountRes;
import com.example.extension_block_system.extension.dto.response.GetCustomExtensionRes;
import com.example.extension_block_system.global.response.ResponseCustom;

public interface ExtensionService {
    void registerExtension(RegisterExtensionReq registerExtensionReq);

    GetCustomExtensionRes getCustomExtension();

    void removeCustomExtension(Long extensionId);

    GetCustomExtensionCountRes getCustomExtensionCount();
}
