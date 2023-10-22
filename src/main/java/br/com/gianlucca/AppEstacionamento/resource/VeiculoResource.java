package br.com.gianlucca.AppEstacionamento.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gianlucca.AppEstacionamento.model.Veiculo;
import br.com.gianlucca.AppEstacionamento.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoResource {
	
	private VeiculoService veiculoService;
	
	public VeiculoResource(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> getAll() {
		List<Veiculo> veiculos = veiculoService.getAll();
		if(veiculos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(veiculos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Veiculo>> getById(@PathVariable Long id) {
		Optional<Veiculo> veiculo = veiculoService.getById(id);
		if(veiculo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(veiculo);
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
		return new ResponseEntity<>(veiculoService.save(veiculo), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Veiculo> update(@RequestBody Veiculo veiculo) {
		return new ResponseEntity<>(veiculoService.update(veiculo), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		veiculoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
}
