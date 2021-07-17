package br.com.api.cadastroclientes;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ArrayList<Clientes> listaClientesParcial(@PathVariable String nome){
				
		return  (ArrayList<Clientes>) clientesRepository.findByNomeContaining(nome);
				
	}	
	
	@PostMapping("/inserir")
	@CrossOrigin
	public void inserirClientes(@RequestBody Clientes cliente) {
		
		clientesRepository.save(cliente);
		
	}
	
	
	@GetMapping("/")
	public String ok() {
		
		return "Serviço funcionando normalmente!";
		
	}
	
}
