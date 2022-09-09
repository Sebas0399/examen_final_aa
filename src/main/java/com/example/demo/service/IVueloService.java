package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Vuelo;

public interface IVueloService {
public List<Vuelo>buscarPorNumero(String numero);
}
