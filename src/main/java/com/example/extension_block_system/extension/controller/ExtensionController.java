package com.example.extension_block_system.extension.controller;

import com.example.extension_block_system.extension.dto.request.RegisterExtensionReq;
import com.example.extension_block_system.extension.service.ExtensionServiceImpl;
import com.example.extension_block_system.global.response.ResponseCustom;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "파일 확장자 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/extensions")
public class ExtensionController {

    private final ExtensionServiceImpl extensionService;

    @PostMapping("")
    public ResponseCustom registerExtension(@RequestBody RegisterExtensionReq registerExtensionReq)
    {
        extensionService.registerExtension(registerExtensionReq);
        return ResponseCustom.OK();
    }

}
