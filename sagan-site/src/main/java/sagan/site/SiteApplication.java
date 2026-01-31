package sagan.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import sagan.site.support.StaticPagePathFinder;

/**
 * The entry point for the Sagan web application.
 */
@SpringBootApplication
@EnableConfigurationProperties(SiteProperties.class)
public class SiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }

    @Bean
    public StaticPagePathFinder staticPagePathFinder(org.springframework.core.io.support.ResourcePatternResolver resourcePatternResolver) {
        return new StaticPagePathFinder(resourcePatternResolver);
    }

}
