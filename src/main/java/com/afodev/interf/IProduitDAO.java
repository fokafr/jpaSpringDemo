package com.afodev.interf;

import java.util.List;

import com.afodev.entity.Produit;

public interface IProduitDAO {
void saveProduit(Produit p);
public List<Produit> findAll();
public Produit findOne(Long id);
public void remove(Long id);
public void update(Long id);
public List<Produit> findByDesignation(String des);

}
