/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.models;

/**
 *
 * @author Felipe
 */
/**
 *
 * @author Tiago
 */
public class User extends Pessoa {

	
	private String cargo;
        private String senha;
	
        public User(String email,Integer matricula, String CPF, String endereco, String nome){
            super(email,matricula, CPF, endereco, nome);
        }
     
	 /** Compara a String digitada com um dado salvo se for igual retorna true,
	 * caso contrario retorna false
	 */
	public boolean autentica(String CPF, String senha) {
		if (!this.senha.equals(senha))
			return false;
		// pode fazer outras possoveis verificacoes

		return true;
	}
	


	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	// -------------------------------------------------------
}
