package com.jpa_test.jpa_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa_test.jpa_example.dao.UserRepository;
import com.jpa_test.jpa_example.entities.User;
import java.util.*;
@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JpaExampleApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);

		// User user=new User();
		// user.setName("pankaj");
		// user.setCity("Nashik");
		// user.setStatus("I am programmer");
		// User user1=userRepository.save(user);
		// System.out.println(user1);


		User user1=new User();
		User user2=new User();
		user1.setName("pankaj");
		user1.setCity("Nashik");
		user1.setStatus("I am programmer");// User user=new User();
		user2.setName("pankaj");
		user2.setCity("Nashik");
		user2.setStatus("I am programmer");

		// for 1 user
		// User ruser=userRepository.save(user1);
		// System.out.println(ruser);

		// for multiple user
		// java.util.List<User> users=java.util.List.of(user1,user2);

		// Iterable <User> result=userRepository.saveAll(users);
		// result.forEach(user->{
		// 	System.out.println(user);
		// });


		//for update data
		// Optional<User> optional=userRepository.findById(52);
		// User user=optional.get();
		// System.out.println(user+user.getName());
		// user.setName("komal");
		// userRepository.save(user);
		// System.out.println(user+user.getName());


		// find all
		/*Iterable<User>itr=userRepository.findAll();
		itr.forEach(action->{
			System.out.println(action.getId());
		});*/
		//for delete by id
		// userRepository.deleteById(2);
		//for delete all users
		//userRepository.deleteAll(itr);
		// Iterable<User>itr2=userRepository.findAll();
		// itr2.forEach(action->{
		// 	System.out.println(action.getId());
		// });
		

		//costom function for query by findBy or other 
		java.util.List <User> users=userRepository.findByName("komal");
		users.forEach(e->{
			System.out.println(e.getId());
		});

		java.util.List <User> user=userRepository.findByNameAndCity("Pankaj","Nashik");
		user.forEach(e->{
			System.out.println(e.getId());
		});

		//constom function for query by annotations;
		java.util.List <User> userq=userRepository.getAllUser();

		userq.forEach(e->{
			System.out.println(e.getId());
		});
		System.out.println("--------");

		//constom function for parameterize query by annotations
		java.util.List <User> userp=userRepository.getAllUserByName("komal");

		userp.forEach(e->{
			System.out.println(e.getId());
		});

		System.out.println("--------");

		//constom function for multiple parameterize query by annotations
		java.util.List <User> userpm=userRepository.getAllUserByNameAndCity("komal","Nashik");

		userpm.forEach(e->{
			System.out.println(e.getId());
		});

		System.out.println("--------");


		//constom function for native query by annotations @query
		java.util.List <User> usernative=userRepository.getUsers();

		usernative.forEach(e->{
			System.out.println(e.getId());
		});



	}

}
