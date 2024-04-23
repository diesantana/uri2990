package com.devsuperior.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

	@Query(nativeQuery = true, value = "SELECT empregados.cpf, empregados.enome, departamentos.dnome "
			+ "FROM empregados "
			+ "JOIN departamentos ON departamentos.dnumero = empregados.dnumero "
			+ "LEFT JOIN trabalha ON empregados.cpf = trabalha.cpf_emp "
			+ "WHERE trabalha.cpf_emp ISNULL "
			+ "ORDER BY empregados.cpf")
	List<EmpregadoDeptProjection> search();
	
}
