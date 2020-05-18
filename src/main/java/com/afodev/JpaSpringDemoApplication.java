package com.afodev;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.afodev.dao.ProduitDaoImpl;
import com.afodev.entity.Produit;
import com.afodev.interf.IProduitDAO;

@SpringBootApplication
public class JpaSpringDemoApplication  {

	public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(JpaSpringDemoApplication.class, args);
	IProduitDAO produitDao = ctx.getBean(ProduitDaoImpl.class);
	Produit p1 = new Produit("pantalon vert", 10.2, 4);
	Produit p2 = new Produit("Chaussure bleu", 5.2, 3);
	Produit p3 = new Produit("pantalon blanc", 15.2,1 );
	produitDao.saveProduit(p1);
	produitDao.saveProduit(p2);
	produitDao.saveProduit(p3);
	
	//Produit p = produitDao.findOne(4L);
	//System.out.println("produit trouvé "+p);
	List<Produit> produits = new ArrayList<>();
	produits = produitDao.findAll();
	System.out.println(produits);
	
	
	
	}

}
