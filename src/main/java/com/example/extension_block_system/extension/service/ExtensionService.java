package com.example.extension_block_system.extension.service;

import com.example.extension_block_system.extension.dto.request.RegisterExtensionReq;
import com.example.extension_block_system.extension.dto.response.GetCustomExtensionCountRes;
import com.example.extension_block_system.extension.dto.response.GetCustomExtensionRes;

public interface ExtensionService {
    Long registerExtension(RegisterExtensionReq registerExtensionReq);

    GetCustomExtensionRes getCustomExtension();

    void removeExtension(Long extensionId);

    GetCustomExtensionCountRes getCustomExtensionCount();
}
