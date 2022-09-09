package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Vuelo;

public interface IClienteGestor {

List<Vuelo> buscarVuelosDisponibles(String origen, String Destino, String fechaVuelo);


void reserva(Integer cantidadAsientosComprados, String cedula, String numeroVuelo);

}
