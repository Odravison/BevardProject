/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.models;


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
     
	public boolean autentica(String CPF, String senha) {
		if (!this.senha.equals(senha)&&!this.getCPF().equals(CPF))
			return false;
		// pode fazer outras possoveis verificacoes(email)

		return true;
	}
	

    public String getCargo() {
    		return cargo;
	}
    public void setCargo(String cargo) {
		this.cargo = cargo;
	}
        
    public String getSenha() {
            return senha;
        }
        
    public void setSenha(String senha) {
         this.senha = senha;
        }


}
