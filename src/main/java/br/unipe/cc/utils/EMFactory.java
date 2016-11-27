package br.unipe.cc.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
	
	private static EMFactory instance = null;
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	private EMFactory(){
		this.emf = Persistence.createEntityManagerFactory("kbmaisumdb");
		this.em = emf.createEntityManager();
	}
	
	public static EntityManager getEntityManager(){
		if (instance == null){
			instance = new EMFactory();
		}
		return instance.em;
	}

}