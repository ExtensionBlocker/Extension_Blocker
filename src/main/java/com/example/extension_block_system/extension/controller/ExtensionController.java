package com.example.extension_block_system.extension.controller;

import com.example.extension_block_system.extension.dto.request.RegisterExtensionReq;
import com.example.extension_block_system.extension.service.ExtensionServiceImpl;
import com.example.extension_block_system.global.response.ResponseCustom;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    @Operation(summary = "확장자 추가", description = "확장자를 추가한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "(S0001)확장자 추가 성공"),
            @ApiResponse(responseCode = "400", description = "(E0005)이미 등록된 확장자 입니다.", content = @Content(schema = @Schema(implementation = ResponseCustom.class)))
    })
    @PostMapping("")
    public ResponseCustom registerExtension(@RequestBody @Valid RegisterExtensionReq registerExtensionReq)
    {
        extensionService.registerExtension(registerExtensionReq);
        return ResponseCustom.OK();
    }

}
