package com.sparta.myblogsparta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // JPA auditing 활성화
@SpringBootApplication
public class MyblogSpartaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyblogSpartaApplication.class, args);
    }

}
