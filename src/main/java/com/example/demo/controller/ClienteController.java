package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.IVueloRepository;
import com.example.demo.repository.modelo.Vuelo;
import com.example.demo.service.IClienteGestor;
import com.example.demo.service.IVueloService;

@RequestMapping("/cliente/")
@Controller
public class ClienteController {
	@Autowired
	private IClienteGestor clienteGestor;
	
	@Autowired
	private IVueloService vueloService;
	@GetMapping("/buscarDisponibles")
	public String buscarDisponibes(Vuelo v) {
		return "vistaFormularioBusqueda";
	}
	
	@GetMapping("/buscar")
	public String buscarDisponibles(Model modelo,@RequestParam(name = "origen")String origen,@RequestParam(name = "destino")String destino,@RequestParam(name = "fechaVuelo")String fechaVuelo) {
		List<Vuelo>lista=this.clienteGestor.buscarVuelosDisponibles(origen, destino, fechaVuelo);
		modelo.addAttribute("vuelos",lista);
		return "vistaListaVuelo";
	}
	
	@GetMapping("/buscarVueloNumero")
	public String buscarVueloNumero(Vuelo v) {
		return "vistaBuscarVuelo";
	}
	
	@GetMapping("/buscarVuelo")
	public String buscarVuelo(Model modelo,@RequestParam(name = "numero")String numero) {
		List<Vuelo>lista=this.vueloService.buscarPorNumero(numero);
		modelo.addAttribute("vuelos",lista);
		return "vistaListaVuelo";
	}
}
