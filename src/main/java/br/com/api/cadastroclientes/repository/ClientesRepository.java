package br.com.api.cadastroclientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.cadastroclientes.domain.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{

	List<Clientes>findByNomeContaining(String nome);
	List<Clientes>findByNome(String nome);	
	
}
