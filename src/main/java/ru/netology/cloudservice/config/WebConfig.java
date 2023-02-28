package ru.netology.cloudservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${app.configuration.cors.origins}")
    private String origins;

    @Value("${app.configuration.cors.headers}")
    private String allowedHeaders;

    @Value("${app.configuration.cors.methods}")
    private String allowedMethods;

    @Value("${app.configuration.cors.allow-credentials}")
    private boolean allowCredentials;

    @Value("${app.configuration.threadPoolTaskExecutor.corePoolSize}")
    private int corePoolSize;

    @Value("${app.configuration.threadPoolTaskExecutor.maxPoolSize}")
    private int maxPoolSize;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/file").setViewName("file");
        registry.addViewController("/list").setViewName("list");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(allowCredentials)
                .allowedOrigins(origins)
                .allowedMethods(allowedMethods)
                .allowedHeaders(allowedHeaders);
    }

    @Bean
    public ThreadPoolTaskExecutor mvcTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        return taskExecutor;
    }

    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(mvcTaskExecutor());
    }

}