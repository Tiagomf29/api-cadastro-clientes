package br.com.api.cadastroclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.cadastroclientes.domain.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{

}
