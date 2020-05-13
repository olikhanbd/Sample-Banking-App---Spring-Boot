package com.oli.authdemo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.oli.authdemo.dao.UserRepository;
import com.oli.authdemo.service.AuthenticationService;
import com.oli.authdemo.utils.Constants;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ComponentScan({"com.oli.authdemo", "utils"})
public class AuthdemoApplication {

	public static void main(String[] args) {
		new File(Constants.UPLOAD_DIR).mkdir();
		SpringApplication.run(AuthdemoApplication.class, args);
	}

}
