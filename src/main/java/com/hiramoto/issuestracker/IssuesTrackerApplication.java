package com.hiramoto.issuestracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.hiramoto.issuestracker")
public class IssuesTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssuesTrackerApplication.class, args);
	}

}
