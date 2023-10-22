package br.com.gianlucca.AppEstacionamento.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.gianlucca.AppEstacionamento.model.Cliente;

public interface ClienteServiceInterface {
	Cliente save(Cliente cliente);
	Optional<Cliente> getById(Long id);
	List<Cliente> getAll();
	Cliente update(Cliente cliente);
	void delete(Long id);
}
