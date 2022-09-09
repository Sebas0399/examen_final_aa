package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Cliente> buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente>myQuery=this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:cedula",Cliente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getResultList();
	}

}
