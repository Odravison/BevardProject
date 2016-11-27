/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.controllers;

import br.unipe.cc.exceptions.VeiculoExistenteException;
import br.unipe.cc.exceptions.VeiculoInexistenteException;
import br.unipe.cc.models.Veiculo;
import br.unipe.cc.persistencia.VeiculoDao;

/**
 *
 * @author odravison
 */
public class VeiculoController {
    
    private static VeiculoController veiculoController;
    private final VeiculoDao userDao;
    
    private VeiculoController(){
        userDao = new VeiculoDao();
    }
    
    public static VeiculoController getInstance(){
        if (veiculoController == null){
         veiculoController = new VeiculoController();
        }
        
        return veiculoController;
    }

    public VeiculoDao getVeiculoDao() {
        return userDao;
    }
    
    public void cadastrarVeiculo(Veiculo veiculo) throws VeiculoExistenteException{
        getVeiculoDao().cadastraVeiculo(veiculo);
    }
    
    public void editarVeiculo(Veiculo veiculo) throws VeiculoInexistenteException{
        getVeiculoDao().editarVeiculo(veiculo);
    }
    
    public Veiculo buscarVeiculo(String placa) throws VeiculoInexistenteException{
        return getVeiculoDao().buscarVeiculo(placa);
    }
    
    public void removerVeiculo(Long id) throws VeiculoInexistenteException{
        getVeiculoDao().removerVeiculo(id);
    }
}
