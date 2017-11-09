package br.com.sysempresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.sysempresa.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"br.com.sysempresa"})
public class ApplicationSpringBoot {
	
	public static void main(String[] args) {
		
	 SpringApplication.run(ApplicationSpringBoot.class, args);
	}
}
