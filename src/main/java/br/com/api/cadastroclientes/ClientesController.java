package br.com.api.cadastroclientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cadastroclientes.domain.Clientes;
import br.com.api.cadastroclientes.repository.ClientesRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClientesController {

	
	@Autowired
	ClientesRepository clientesRepository;
	
	@GetMapping("/listar")
	@CrossOrigin
	public ArrayList<Clientes> listaClientes(){
				
		return  (ArrayList<Clientes>) clientesRepository.findAll();
				
	}
	
	
	@GetMapping("/listarPorNome/{nome}")
	@CrossOrigin
	public  ArrayList<Clientes> listaClientesParcial(@PathVariable String nome){
		
		List<Clientes> lista = clientesRepository.findByNomeContaining(nome); 
		
		if (lista.size() > 0){
			return (ArrayList<Clientes>) lista;
		}else {	
		
			return null;
		}
				
	}	
	
	@PostMapping("/inserir")
	@CrossOrigin
	public ResponseEntity<Clientes> inserirClientes(@RequestBody Clientes cliente) {
		
		
		List<Clientes> lista = clientesRepository.findByNome(cliente.getNome()); 
		
		if (lista.size() >=1){
			return ResponseEntity.noContent().build();
		}else {		
			clientesRepository.save(cliente);
			return ResponseEntity.ok(cliente);
		}
		
	}
	
	
	@GetMapping("/")
	public String ok() {
		
		return "Serviço funcionando normalmente!";
		
	}
	
}
