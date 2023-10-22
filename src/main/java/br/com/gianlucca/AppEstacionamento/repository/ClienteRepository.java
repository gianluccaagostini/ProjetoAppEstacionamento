package br.com.gianlucca.AppEstacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gianlucca.AppEstacionamento.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
