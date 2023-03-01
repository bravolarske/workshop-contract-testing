package com.axxes.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {
		"com.axxes:producer:+:stubs:8095" }, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ConsumerApplicationTests {

	private final TestRestTemplate restTemplate = new TestRestTemplate();

	@Test()
	public void testContract() {
		MealVoucher result = restTemplate.getForObject("http://localhost:8095/api/meal-vouchers/10", MealVoucher.class);
		assertThat(result.amount).isEqualTo(80);
		assertThat(result.endDate).isEqualTo( LocalDate.of(1996,12,2));
	}

	record MealVoucher(int amount, LocalDate endDate) {
	}

}
