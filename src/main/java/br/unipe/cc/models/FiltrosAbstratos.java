/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.models;

import java.util.HashMap;

public class FiltrosAbstratos {
	
	
	private HashMap<Object, Object> filtros = new HashMap<Object, Object>();
	
	
	public FiltrosAbstratos(HashMap args){
		filtros = args;
	}

	public HashMap<Object, Object> getFiltros() {
		return filtros;
	}

}
