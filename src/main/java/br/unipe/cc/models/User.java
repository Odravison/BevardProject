/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.models;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Tiago
 */
@Entity
@Table(name = "Users")
@AttributeOverride(name = "id", column = @Column(name = "id_user"))
public class User extends EntidadePersistivel {

    private String cargo;
    private String senha;
    private String email;
    private String telefone;
    private Integer matricula;
    private String CPF;
    private String endereco;
    private String nome;

    public User(String email, Integer matricula, String CPF, String endereco, String nome, String cargo, String senha) {
        this.cargo = cargo;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.CPF = CPF;
        this.endereco = endereco;
        this.nome = nome;
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
