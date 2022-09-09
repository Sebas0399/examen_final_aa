package com.example.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="compra_pasaje")
public class CompraPasaje {
	@Id
	@Column(name="copa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "copa_id_seq")
	@SequenceGenerator(name = "copa_id_seq", sequenceName = "copa_id_seq", allocationSize = 1)

	private Integer id;
	@Column(name="copa_numero")
	private String numero;
	@Column(name="copa_fecha_compra")
	private String fechaCompra;
	@Column(name="copa_cantidad_asientos_comprados")
	private Integer cantidadAsientosComprados;
	@Column(name="copa_estado")
	//reservadp
	private String estado;
	@JoinColumn(name="copa_vuel_id")
	@ManyToOne
	private Vuelo vuelo;
	@JoinColumn(name="copa_clie_id")
	@ManyToOne
	private Cliente cliente;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Integer getCantidadAsientosComprados() {
		return cantidadAsientosComprados;
	}
	public void setCantidadAsientosComprados(Integer cantidadAsientosComprados) {
		this.cantidadAsientosComprados = cantidadAsientosComprados;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
