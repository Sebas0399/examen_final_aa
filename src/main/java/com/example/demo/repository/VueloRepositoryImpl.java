package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Vuelo> buscarVuelos(String origen, String destino, String fechaVuelo) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Vuelo> myQuery = myBuilder.createQuery(Vuelo.class);
		Root<Vuelo> myTabla = myQuery.from(Vuelo.class);
		Predicate whereOrigen = myBuilder.equal(myTabla.get("origen"), origen);
		Predicate whereDestino = myBuilder.equal(myTabla.get("destino"), destino);
		Predicate wherefechaVuelo = myBuilder.equal(myTabla.get("fechaVuelo"), fechaVuelo);

		TypedQuery<Vuelo> queryFinal = this.entityManager
				.createQuery(myQuery.where(whereOrigen).where(whereDestino).where(wherefechaVuelo));

		return queryFinal.getResultList();
	}

	@Override
	public List<Vuelo> buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo>myQuery=this.entityManager.createQuery("SELECT v FROM Vuelo v WHERE v.numero=:numero",Vuelo.class);
		myQuery.setParameter("numero",numero);
		return null;
	}

}
