package com.cafe.damanha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cafe.damanha.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

	@Query(value = "SELECT * FROM TAB_FUNCIONARIO ORDER BY NOME", nativeQuery = true)
	List<Funcionario> listFuncionarios();

	@Query(value = "SELECT * FROM TAB_FUNCIONARIO WHERE CPF = :cpf ORDER BY NOME", nativeQuery = true)
	List<Funcionario> listFuncionarios(String cpf);

	@Query(value = "INSERT INTO TAB_FUNCIONARIO (id,nome,cpf,itemcafe) values ( 'null' ,:nome, :cpf , :itemcafe )", nativeQuery = true)
	Funcionario persist(@Param("nome") String nome, 
						@Param("cpf") String cpf,
						@Param("itemcafe") String itemcafe);

	@Query(value = "DELETE FROM TAB_FUNCIONARIO)", nativeQuery = true)
	Funcionario deletartudo();

	
			@Query(value = "UPDATE TAB_FUNCIONARIO SET CPF = :cpf , ITEMCAFE = :itemcafe , NOME = :nome WHERE id = :id)", nativeQuery = true)
	Funcionario atualizar(@Param("nome") String nome, 
						  @Param("cpf") String cpf, 
						  @Param("itemcafe") String itemcafe,
						  @Param("id") int id);
	
}
