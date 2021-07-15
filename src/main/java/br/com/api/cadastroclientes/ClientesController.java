package br.com.api.cadastroclientes;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cadastroclientes.domain.Clientes;
import br.com.api.cadastroclientes.repository.ClientesRepository;

@RestController
@RequestMapping("/api")
public class ClientesController {

	
	@Autowired
	ClientesRepository clientesRepository;
	
	@GetMapping("/listar")
	public ArrayList<Clientes> listaClientes(){
				
		return  (ArrayList<Clientes>) clientesRepository.findAll();
				
	}
	
	@PostMapping("/inserir/{nome}")
	public void inserirClientes(@PathVariable String nome) {
		
		Clientes c = new Clientes();
		c.setNome(nome);
		clientesRepository.save(c);
		
	}
	
	
	@GetMapping("/")
	public String ok() {
		
		return "Serviço funcionando normalmente!";
		
	}
	
}
