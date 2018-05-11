package com.jp.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@EnableCouchbaseRepositories
@SpringBootApplication
public class UserRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}
}
