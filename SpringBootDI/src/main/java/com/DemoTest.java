package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoTest {

	public static void main(String[] args) {
		SpringApplication.run(DemoTest.class, args);
		System.out.println("Spring boot is ready");
		AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext();
		ac.scan("com");
		ac.refresh();
		Employee emp=(Employee)ac.getBean("employee");
		System.out.println(emp);
	}

}
