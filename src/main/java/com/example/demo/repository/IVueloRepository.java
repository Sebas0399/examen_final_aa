package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vuelo;

public interface IVueloRepository {
public List<Vuelo>buscarVuelos(String origen,String Destino,String fechaVuelo);
public List<Vuelo>buscarPorNumero(String numero);
}
