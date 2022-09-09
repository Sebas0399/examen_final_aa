package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="vuelo")
public class Vuelo {
	@Id
	@Column(name="vuel_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vuel_id_seq")
	@SequenceGenerator(name = "vuel_id_seq", sequenceName = "vuel_id_seq", allocationSize = 1)

private Integer id;
	@Column(name="vuel_numero")
private String numero;
	@Column(name="vuel_fechaVuelo")
private String fechaVuelo;
	@Column(name="vuel_valor_asiento")
private BigDecimal valorAsiento;
	//DIS ; ND
	@Column(name="vuel_estado")
private String estado;
	@Column(name="vuel_origen")
	private String origen;
	@Column(name="vuel_destino")
	private String destino;
	@ManyToOne
	@JoinColumn(name = "vuel_avio_id")
	private Avion avion;
	@OneToMany(mappedBy = "vuelo")
	private List<CompraPasaje>pasajes;
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
	public String getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}
	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public List<CompraPasaje> getPasajes() {
		return pasajes;
	}
	public void setPasajes(List<CompraPasaje> pasajes) {
		this.pasajes = pasajes;
	}
	
	
}
