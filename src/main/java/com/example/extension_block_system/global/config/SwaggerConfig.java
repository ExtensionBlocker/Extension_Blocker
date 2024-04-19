package com.example.extension_block_system.global.config;


import com.example.extension_block_system.global.Constants;
import com.example.extension_block_system.global.exception.BaseResponseCode;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private static final String API_NAME = "EXTENSION_BLOCKER_API";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "EXTENSION_BLOCKER_API_명세서";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .components(components());
    }

    public Info apiInfo() {
        return new Info()
                .title(API_NAME)
                .version(API_VERSION)
                .description(getApiDescription(getErrorList()));
    }

    public Components components() {
        return new Components()
                .addSecuritySchemes(Constants.Swagger.bearerKey, securityScheme());
    }

    public SecurityScheme securityScheme() {
        return new io.swagger.v3.oas.models.security.SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
    }

    private String getErrorList() {
        StringBuilder errorList = new StringBuilder();
        BaseResponseCode[] exceptionLists = BaseResponseCode.values();
        for (BaseResponseCode exceptionList : exceptionLists) {
            errorList.append("<tr>");
            errorList.append("<td>").append(exceptionList.getCode()).append("</td>");
            errorList.append("<td>").append(exceptionList.getStatus()).append("</td>");
            errorList.append("<td>").append(exceptionList.getMessage()).append("</td>");
            errorList.append("</tr>");
        }
        return errorList.toString();
    }

    public String getApiDescription(String errorList) {
        String description = """
                ExtensionBlocker API 명세서입니다.<br>
                스웨거 한계로 인해 Response에 공통 response의 data에 대한 정의가 되어있습니다. <br>
                <details>
                    <summary> ERROR LIST </summary>
                    <table>
                        <thead>
                        <tr>
                            <th>ERROR CODE</th>
                            <th>STATUS</th>
                            <th>ERROR MESSAGE</th>
                        </tr>
                        </thead>
                        <tbody>
                            """
                + errorList
                + """
                        </tbody>
                    <table>
                </details>
                """;
        return description;
    }
}
