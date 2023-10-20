package web.api.assessment.calculation.demo;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import web.api.assessment.service.RewardsService;

@Profile("test")
@Configuration
public class RewardsServiceTestConfiguration {

	@Bean
	@Primary
	public RewardsService rewardsService() {
		return Mockito.mock(RewardsService.class);
	}
}
