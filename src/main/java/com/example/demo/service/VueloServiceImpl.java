package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVueloRepository;
import com.example.demo.repository.modelo.Vuelo;
@Service
public class VueloServiceImpl implements IVueloService {
	@Autowired
	private IVueloRepository vueloRepo;
	@Override
	public List<Vuelo> buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		List<Vuelo>lista=this.buscarPorNumero(numero);
		lista=lista.stream().filter(t->t.getEstado().equals("DIS")).toList();
		return this.vueloRepo.buscarPorNumero(numero);
	}

}
