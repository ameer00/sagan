package sagan.site.support.observability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GitHubHealthIndicatorTests {

	@Mock
	private RestTemplateBuilder builder;

	@Mock
	private RestTemplate restTemplate;

	private GitHubHealthIndicator indicator;

	@BeforeEach
	void setUp() {
		given(builder.build()).willReturn(restTemplate);
		indicator = new GitHubHealthIndicator(builder);
	}

	@Test
	void healthUp() {
		given(restTemplate.getForEntity(eq("https://api.github.com/"), any()))
				.willReturn(ResponseEntity.ok().build());

		Health health = indicator.health();
		assertThat(health.getStatus()).isEqualTo(Status.UP);
	}

	@Test
	void healthDown() {
		given(restTemplate.getForEntity(eq("https://api.github.com/"), any()))
				.willThrow(new RuntimeException("API Down"));

		Health health = indicator.health();
		assertThat(health.getStatus()).isEqualTo(Status.DOWN);
		assertThat(health.getDetails()).containsKey("error");
	}
}
