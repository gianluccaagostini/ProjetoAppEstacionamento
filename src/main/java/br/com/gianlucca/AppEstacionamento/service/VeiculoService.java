package br.com.gianlucca.AppEstacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gianlucca.AppEstacionamento.model.Veiculo;
import br.com.gianlucca.AppEstacionamento.repository.VeiculoRepository;
import br.com.gianlucca.AppEstacionamento.service.interfaces.VeiculoServiceInterface;

public class VeiculoService implements VeiculoServiceInterface {
	
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
		
	}

	@Override
	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public Optional<Veiculo> getById(long id) {
		return veiculoRepository.findById(id);
	}

	@Override
	public List<Veiculo> getAll() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo update(Veiculo veiculo) {
		Optional<Veiculo> upVeiculo = veiculoRepository.findById(veiculo.getId());
		if(upVeiculo.isPresent()) {
			Veiculo newVeiculo = upVeiculo.get();
			newVeiculo.setCliente(veiculo.getCliente());
			newVeiculo.setVezesUtilizado(veiculo.getVezesUtilizado());
			return veiculoRepository.save(newVeiculo);
		}
		return veiculo;
	}

	@Override
	public void delete(Long id) {
		veiculoRepository.deleteById(id);
		
	}

	@Override
	public Veiculo addVezesUtilizado(Long id, int vezesUtilizado) {
		return veiculoRepository.findById(id).map(veiculo -> {
			veiculo.setVezesUtilizado(veiculo.getVezesUtilizado() + vezesUtilizado);
			return veiculoRepository.save(veiculo);
		}).orElseThrow();
	}

	@Override
	public Veiculo delVezesUtilizado(Long id, int vezesUtilizado) {
		return veiculoRepository.findById(id).map(veiculo -> {
			veiculo.setVezesUtilizado(veiculo.getVezesUtilizado() - vezesUtilizado);
			return veiculoRepository.save(veiculo);
		}).orElseThrow();
	}

}
