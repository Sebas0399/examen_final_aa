package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.ICompraPasajeRepository;
import com.example.demo.repository.IVueloRepository;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.CompraPasaje;
import com.example.demo.repository.modelo.Vuelo;
@Service
public class ClienteGestorImpl implements IClienteGestor{
	@Autowired
	private IVueloRepository vueloRepo;
	@Autowired
	private IClienteRepository clienteRepo;
	@Autowired
	private ICompraPasajeRepository compraPasajeRepo;
	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen,String Destino,String fechaVuelo) {
		// TODO Auto-generated method stub
	
		List<Vuelo>lista=this.vueloRepo.buscarVuelos(origen, Destino, fechaVuelo);
		lista=lista.stream().filter(t->t.getEstado().equalsIgnoreCase("dis")).toList();
		return lista;
	}

	

	@Override
	public void reserva(Integer cantidadAsientosComprados, String cedula,String numero) {
		// TODO Auto-generated method stub
		Cliente cliente=this.clienteRepo.buscarPorCedula(cedula).get(0);
		Vuelo vuelo=this.vueloRepo.buscarPorNumero(numero).get(0);
		
		CompraPasaje compraPasaje=new CompraPasaje();
		compraPasaje.setCantidadAsientosComprados(cantidadAsientosComprados);
		compraPasaje.setCliente(cliente);
		compraPasaje.setFechaCompra(LocalDateTime.now().toString());
		compraPasaje.setVuelo(vuelo);
		compraPasaje.setEstado("RES");
		this.compraPasajeRepo.insertar(compraPasaje);
		
	}

}
