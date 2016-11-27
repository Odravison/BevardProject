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
public class Seguro extends EntidadePersistivel{
    private String descricaoContrato;
    private Veiculo veiculo;
    private Pessoa cliente;
    public Seguro(String descricaoContrato){
           this.descricaoContrato = descricaoContrato;
        }

	
}
