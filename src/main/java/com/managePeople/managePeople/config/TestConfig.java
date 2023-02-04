package com.managePeople.managePeople.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.managePeople.managePeople.model.Address;
import com.managePeople.managePeople.model.User;
import com.managePeople.managePeople.repositories.AddressRepository;
import com.managePeople.managePeople.repositories.UserRepository;

@Configuration
@Profile("test")  //nome igual application.properties para rodar aqui
public class TestConfig implements CommandLineRunner {  

	//popular o banco de dados teste - database seeding
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void run(String... args) throws Exception {
		//quando aplicação iniciada ele roda aqui
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date data1 = formato.parse("23/11/1996");
		Date data2 = formato.parse("23/09/1998");
		
		User u1 = new User(null, "Rodrigo", data1);
		User u2 = new User(null, "Bruno", data2);
		User u3 = new User(null, "Murilo", null);
		
		Address a1 = new Address(null, "test Logradouro", 123456, 611, "Campinas", u1);
		Address a2 = new Address(null, "test Logradouro", 13341089, 1036, "Vinhedo", u1);
		Address a3 = new Address(null, "test Logradouro", 13341089, 1036, "Vinhedo", u2);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		addressRepository.saveAll(Arrays.asList(a1, a2, a3));
		
	}
	
	
	
}
