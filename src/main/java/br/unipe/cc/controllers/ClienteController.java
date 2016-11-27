/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.controllers;

import br.unipe.cc.exceptions.ClienteExistenteException;
import br.unipe.cc.exceptions.ClienteInexistenteException;
import br.unipe.cc.models.Cliente;
import br.unipe.cc.persistencia.ClienteDao;

/**
 *
 * @author odravison
 */
public class ClienteController {
    
    private static ClienteController clienteController;
    private final ClienteDao clienteDao;
    
    private ClienteController(){
        clienteDao = new ClienteDao();
    }
    
    public static ClienteController getInstance(){
        if (clienteController == null){
         clienteController = new ClienteController();
        }
        
        return clienteController;
    }
    
    public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException{
        getClienteDao().cadastraCliente(cliente);
    }
    
    public void editarCliente(Cliente cliente) throws ClienteInexistenteException{
        getClienteDao().editarCliente(cliente);
    }
    
    public void removerCliente(String CPF) throws ClienteInexistenteException{
        getClienteDao().removerCliente(CPF);
    }
    
    public void buscarCliente(String CPF) throws ClienteInexistenteException{
        getClienteDao().buscarCliente(CPF);
    }
    
    private ClienteDao getClienteDao() {
        return clienteDao;
    }
    
    
    
    
}
