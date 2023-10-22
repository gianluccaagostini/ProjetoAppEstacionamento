package br.com.gianlucca.AppEstacionamento.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gianlucca.AppEstacionamento.model.Cliente;
import br.com.gianlucca.AppEstacionamento.service.ClienteService;

@RestController
@RequestMapping("/cliente/veiculos")
public class ClienteResource {

	private ClienteService clienteService;
	
	@Autowired
	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes() {
		List<Cliente> clientes = clienteService.getAll();
		if(clientes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> getById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.getById(id);
		if(cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		Cliente newCliente = clienteService.update(cliente);
		if(newCliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newCliente);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		Cliente newCliente = clienteService.update(cliente);
		if(newCliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newCliente);
	}
	
	public ResponseEntity<?> delete(@PathVariable Long id) {
		clienteService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
