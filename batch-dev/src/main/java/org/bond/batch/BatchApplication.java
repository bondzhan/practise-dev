package org.bond.batch;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BatchApplication {

	@Autowired
	private static JobLauncher jobLauncher;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
	
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource masterSourceConfig() {
		return new DataSource();
	}

}
