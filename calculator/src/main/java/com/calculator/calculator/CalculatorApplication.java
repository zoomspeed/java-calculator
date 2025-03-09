package com.calculator.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CalculatorApplication {
	public static void main(String[] args) {
		if (args.length > 0 && args[0].equalsIgnoreCase("cli")) {
			// CLI 모드로 실행 (Web 환경 비활성화)
			SpringApplication app = new SpringApplication(CalculatorApplication.class);
			app.setWebApplicationType(WebApplicationType.NONE);  // Web 서버 실행 방지
			ConfigurableApplicationContext context = app.run(args);
			context.close(); // CLI 실행 후 종료
		} else {
			// Web 애플리케이션 실행 (기본 모드)
			SpringApplication.run(CalculatorApplication.class, args);
		}
	}
}