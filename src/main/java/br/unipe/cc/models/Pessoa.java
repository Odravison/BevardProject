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
public class Pessoa extends EntidadePersistivel{
 
	private String email;
	private String telefone;
	private Integer matricula;
	private String CPF;
	private String endereco;
	private String nome;
  
        public Pessoa(String email,Integer matricula, String CPF, String endereco, String nome){
            
           this.email=email;
           this.matricula=matricula;
           this.CPF=CPF;
           this.endereco=endereco;
           this.nome=nome;
        }

        public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
