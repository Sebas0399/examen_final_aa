package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteRepository {


public List<Cliente> buscarPorCedula(String cedula);
}
