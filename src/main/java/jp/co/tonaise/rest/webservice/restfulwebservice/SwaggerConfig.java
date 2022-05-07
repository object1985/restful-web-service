package jp.co.tonaise.rest.webservice.restfulwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Bean - Docket
    @Bean
    public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
	return new ApiInfoBuilder()
		// タイトル
		.title("Swaggerお試しAPI")
		// 詳細な説明
		.description("Userの検索・作成・更新・削除ができるAPIです")
		// バージョン
		.version("0.0.1")
		// 連絡先
		.contact(new Contact("tonaise", "https://tonaise.hatenablog.jp/", "tonainose@example.com"))
		// ライセンス名
		.license("Apache 2.0")
		// ライセンスURL
		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
		// 利用規約のURL
		.termsOfServiceUrl("http://example.com/termsofuse").build();
    }
}
