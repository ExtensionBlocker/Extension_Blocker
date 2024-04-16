package com.example.extension_block_system.extension.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "파일 확장자 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class ExtensionController {
}
