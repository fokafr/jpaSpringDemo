package com.afodev.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.afodev.entity.Produit;
import com.afodev.interf.IProduitDAO;

@Repository //Le component est un composant de la couche DAO
@Transactional //on delègue la gestion de la transaction à spring
public class ProduitDaoImpl extends AbstractDao<Produit> implements IProduitDAO{

	@Autowired //injection du composant EntityManager
    private EntityManager  entityManager; 
	
	public void saveProduit(Produit p) {
		super.save(p);
		
	}

	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<Produit>();
		Query query = entityManager.createQuery("select p from Produit p");
		produits = query.getResultList();
		return produits;
	}

	@Override
	public Produit findOne(Long id) {
		// TODO Auto-generated method stub
		Produit p = entityManager.find(Produit.class, id);
		return p;
	}

	@Override
	public void remove(Long id) {
		Produit p = entityManager.find(Produit.class, id);
		entityManager.remove(p);
				
	}

	@Override
	public void update(Long id) {
		super.update(Produit.class, id);
	}

	@Override
	public List<Produit> findByDesignation(String des) {
		Query query = entityManager.createQuery("select p from Produit p where p.designation like :x");
		query.setParameter("x", "%"+des+"%");
		return query.getResultList();
	}

	@Override
	public EntityManager getEm() {
		return entityManager;
	}

}
