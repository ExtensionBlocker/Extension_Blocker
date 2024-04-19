package com.example.extension_block_system.extension.controller;

import com.example.extension_block_system.extension.dto.request.RegisterExtensionReq;
import com.example.extension_block_system.extension.dto.response.FixedCustomRes;
import com.example.extension_block_system.extension.dto.response.GetCustomExtensionCountRes;
import com.example.extension_block_system.extension.dto.response.GetCustomExtensionRes;
import com.example.extension_block_system.extension.service.ExtensionServiceImpl;
import com.example.extension_block_system.global.response.ResponseCustom;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public ResponseCustom<Long> registerExtension(@RequestBody @Valid RegisterExtensionReq registerExtensionReq)
    {
        return ResponseCustom.OK(extensionService.registerExtension(registerExtensionReq));
    }

    @Operation(summary = "커스텀 확장자 조회", description = "커스텀 확장자를 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "(S0001)확장자 조회 성공"),
    })
    @GetMapping("")
    public ResponseCustom<GetCustomExtensionRes> getCustomExtension()
    {
        return ResponseCustom.OK(extensionService.getCustomExtension());
    }


    @Operation(summary = "확장자 삭제", description = "확장자를 삭제한다..")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "(S0001)확장자 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "(E0007)확장자를 찾을 수 없습니다.", content = @Content(schema = @Schema(implementation = ResponseCustom.class)))
    })
    @DeleteMapping("{extensionId}")
    public ResponseCustom removeExtension(
            @Parameter(description = "(Long) 확장자 Id", example = "1") @PathVariable Long extensionId)
    {
        extensionService.removeExtension(extensionId);
        return ResponseCustom.OK();
    }

    @Operation(summary = "커스텀 확장자 개수 조회", description = "커스텀 확장자 개수를 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "(S0001)커스텀 확장자 개수 조회 성공"),
    })
    @GetMapping("/count")
    public ResponseCustom<GetCustomExtensionCountRes> getCustomExtensionCount()
    {
        return ResponseCustom.OK(extensionService.getCustomExtensionCount());
    }

    @Operation(summary = "커스텀 확장자 개수 조회", description = "커스텀 확장자 개수를 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "(S0001)커스텀 확장자 개수 조회 성공"),
    })
    @GetMapping("/fixed")
    public ResponseCustom<FixedCustomRes> getFixedCustom() {
        return ResponseCustom.OK(extensionService.getFixedCustom());
    }
}
