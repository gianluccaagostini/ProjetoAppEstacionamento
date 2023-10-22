package br.com.gianlucca.AppEstacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gianlucca.AppEstacionamento.model.Cliente;
import br.com.gianlucca.AppEstacionamento.repository.ClienteRepository;
import br.com.gianlucca.AppEstacionamento.service.interfaces.ClienteServiceInterface;

@Service
public class ClienteService implements ClienteServiceInterface {

	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Optional<Cliente> getById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente update(Cliente cliente) {
		//Busca do veiculo
		Optional<Cliente> upCliente = clienteRepository.findById(cliente.getId());
		
		if(upCliente.isPresent()) {
			Cliente newCliente = upCliente.get();
			newCliente.setNome(cliente.getNome());
			newCliente.setTelefone(cliente.getTelefone());
			newCliente.setCpf(cliente.getCpf());
			newCliente.setValorPago(cliente.getValorPago());
			return clienteRepository.save(newCliente);	
		}
		return cliente;
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
		
	}
	
	
}
