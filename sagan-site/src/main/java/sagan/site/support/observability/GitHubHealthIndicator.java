package sagan.site.support.observability;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class GitHubHealthIndicator implements HealthIndicator {

	private final RestOperations restOperations;

	public GitHubHealthIndicator(RestTemplateBuilder builder) {
		this.restOperations = builder.build();
	}

	@Override
	public Health health() {
		try {
			restOperations.getForEntity("https://api.github.com/", Void.class);
			return Health.up().build();
		}
		catch (Exception e) {
			return Health.down().withException(e).build();
		}
	}
}
