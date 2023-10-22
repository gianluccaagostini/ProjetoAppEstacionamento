package br.com.gianlucca.AppEstacionamento.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.gianlucca.AppEstacionamento.model.Veiculo;

public interface VeiculoServiceInterface {
	Veiculo save(Veiculo veiculo);
	Optional<Veiculo> getById(long id);
	List<Veiculo> getAll();
	Veiculo update(Veiculo veiculo);
	void delete(Long id);
	Veiculo addVezesUtilizado(Long id, int vezesUtilizado);
	Veiculo delVezesUtilizado(Long id, int vezesUtilizado);
}
