package com.soon83.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

public class WebMvcConfig {

    /**
     * dev profile
     */
    //@Profile({"dev"})
    @Configuration
    public static class DevMvcConfiguration implements WebMvcConfigurer {

        public static final String ALL = "*";

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            // 서버로 들어오는 모든 요청을 SPA 라우팅으로 전환
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/static/")
                    .resourceChain(true)
                    .addResolver(new PathResourceResolver() {
                        @Override
                        protected Resource getResource(String resourcePath, Resource location) throws IOException {
                            Resource requestedResource = location.createRelative(resourcePath);
                            return requestedResource.exists() && requestedResource.isReadable()
                                    ? requestedResource
                                    : new ClassPathResource("/static/index.html");
                        }
                    });

        }


        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins(ALL)
                    .allowedMethods(ALL);
        }
    }
}