package com.bramli.customerservice;

import com.bramli.customerservice.entities.Customer;
import com.bramli.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository repo, RepositoryRestConfiguration repositoryRestConfiguration) {
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			repo.save(new Customer(null, "Mohamed", "mohamed@gmail.com"));
			repo.save(new Customer(null, "Haythem", "Haythem@gmail.com"));
			repo.save(new Customer(null, "Bramli", "Bramli@gmail.com"));
			repo.findAll().forEach(customer -> System.out.println(customer.toString()));
		};
	}
}
