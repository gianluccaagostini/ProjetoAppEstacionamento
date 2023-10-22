package br.com.gianlucca.AppEstacionamento.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")	
	private Cliente cliente;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private String tempoEstacionado;
	
	@Column(nullable = false)
	private int vezesUtilizado;
	
	//Construtores
	public Veiculo() {}
	
	public Veiculo(Long id, Cliente cliente, String modelo, String placa, String tempoEstacionado, int vezesUtilizado) {
		this.id = id;
		this.cliente = cliente;
		this.modelo = modelo;
		this.placa = placa;
		this.tempoEstacionado = tempoEstacionado;

		this.vezesUtilizado = vezesUtilizado;
	}
	
	//Getters and Setters
	
	public void adicionarVeiculo(int vezesUtilizado) {
		this.vezesUtilizado += vezesUtilizado; 		
	}
	

	public void removerVeiculo(int vezesUtilizado) {
		this.vezesUtilizado -= vezesUtilizado; 
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTempoEstacionado() {
		return tempoEstacionado;
	}

	public void setTempoEstacionado(String tempoEstacionado) {
		this.tempoEstacionado = tempoEstacionado;
	}

	public int getVezesUtilizado() {
		return vezesUtilizado;
	}

	public void setVezesUtilizado(int vezesUtilizado) {
		this.vezesUtilizado = vezesUtilizado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}

	
}
