package com.devsuperior.uri2990;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<EmpregadoDeptDTO> resultSQL = repository.search()
				.stream().map(x -> new EmpregadoDeptDTO(x)).toList();
		
		for (EmpregadoDeptDTO empregadoDeptDTO : resultSQL) {
			System.out.println(empregadoDeptDTO);
		}
	}
}
