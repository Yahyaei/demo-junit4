package com.example.demojunit4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoJunit4Application {


	public static void main(String[] args) {
		SpringApplication.run(DemoJunit4Application.class, args);
		Scanner scan = new Scanner(System.in);
		Calculator calc = new Calculator();
		System.out.println(" Hello and Welcome to my counting is fun game! ");






	}

}
