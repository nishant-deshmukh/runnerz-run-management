package com.example.runnerz;

import com.example.runnerz.user.User;
import com.example.runnerz.user.UserHttpClient;
import com.example.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	UserHttpClient userHttpClient(){
		RestClient restClient=RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory= HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}


	@Bean                     // UserHttpClient
	CommandLineRunner runner(UserRestClient client) {
		return args -> {
			List<User> users = client.findAll();
			System.out.println(users);


			User user = client.findById(1);
			System.out.println(user);
		};
	}

	// ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	// log.info("Application started successfully");
	// WelcomeMessage welcomeMessage= (WelcomeMessage) context.getBean("welcomeMessage" );
	// System.out.println(welcomeMessage);

	// @Bean
	// CommandLineRunner runner(RunRepository runRepository){
	//   return args -> {
	//       Run run = new Run(1, "First Run", LocalDateTime.now(),
	//                         LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
	//       log.info("Run: "+ run);
	//       runRepository.create(run);
	//   };
	// }
}
