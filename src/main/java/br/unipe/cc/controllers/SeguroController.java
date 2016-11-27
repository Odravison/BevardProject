/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.controllers;

import br.unipe.cc.exceptions.SeguroExistenteException;
import br.unipe.cc.exceptions.SeguroInexistenteException;
import br.unipe.cc.models.Seguro;
import br.unipe.cc.persistencia.SeguroDao;
import java.util.List;

/**
 *
 * @author odravison
 */
public class SeguroController {
    
    private static SeguroController seguroController;
    private final SeguroDao seguroDao;
    
    private SeguroController(){
        seguroDao = new SeguroDao();
    }
    
    public static SeguroController getInstance(){
        if (seguroController == null){
         seguroController = new SeguroController();
        }
        
        return seguroController;
    }

    public SeguroDao getSeguroDao() {
        return seguroDao;
    }
    
    public void cadastrarSeguro(Seguro seguro) throws SeguroExistenteException{
        getSeguroDao().cadastraSeguro(seguro);
    }
    
    public void editarSeguro(Seguro seguro) throws SeguroInexistenteException{
        getSeguroDao().editarSeguro(seguro);
    }
    
    public List<Seguro> buscarSeguro(String CPFCliente) throws SeguroInexistenteException{
        return getSeguroDao().buscarSeguro(CPFCliente);
        
    }
    
    public void removerSeguro(Long id) throws SeguroInexistenteException{
        getSeguroDao().removerSeguro(id);
    }
    
}
