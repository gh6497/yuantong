package cn.sprivacy.yuantong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author cailun
 * @date 2018年 07月27日
 */

    @Configuration
    public class CorsConfig {
        private CorsConfiguration buildConfig() {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            // 1
            corsConfiguration.addAllowedOrigin("*");
            // 2
            corsConfiguration.addAllowedHeader("*");
            // 3
            corsConfiguration.addAllowedMethod("*");
            return corsConfiguration;
        }

        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            // 4
            source.registerCorsConfiguration("/**", buildConfig());
            return new CorsFilter(source);
        }
    }


