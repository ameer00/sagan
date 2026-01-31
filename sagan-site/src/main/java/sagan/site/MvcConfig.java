package sagan.site;

import java.io.IOException;

import sagan.site.support.StaticPagePathFinder;
import sagan.site.support.ThymeleafRequestInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Site-wide MVC infrastructure configuration. See also {@link SiteApplication} where
 * certain additional web infrastructure is configured.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	private final StaticPagePathFinder staticPagePathFinder;
	private final ThymeleafRequestInterceptor thymeleafRequestInterceptor;

	public MvcConfig(	StaticPagePathFinder staticPagePathFinder,
						ThymeleafRequestInterceptor thymeleafRequestInterceptor) {
		this.staticPagePathFinder = staticPagePathFinder;
		this.thymeleafRequestInterceptor = thymeleafRequestInterceptor;
	}

	@Override
	public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
		registry.addInterceptor(thymeleafRequestInterceptor);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		try {
			for (StaticPagePathFinder.PagePaths paths : staticPagePathFinder.findPaths()) {
				String urlPath = paths.getUrlPath();
				registry.addViewController(urlPath).setViewName("pages" + paths.getFilePath());
				if (!urlPath.isEmpty()) {
					registry.addViewController(urlPath + "/").setViewName("pages" + paths.getFilePath());
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("Unable to locate static pages: " + e.getMessage(), e);
		}
	}

}