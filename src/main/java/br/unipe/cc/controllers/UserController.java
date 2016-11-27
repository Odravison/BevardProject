/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.controllers;

import br.unipe.cc.exceptions.UserExistenteException;
import br.unipe.cc.exceptions.UserInexistenteException;
import br.unipe.cc.models.User;
import br.unipe.cc.persistencia.UserDao;

/**
 *
 * @author odravison
 */
public class UserController {
    
    private static UserController userController;
    private final UserDao userDao;
    
    private UserController(){
        userDao = new UserDao();
    }
    
    public static UserController getInstance(){
        if (userController == null){
         userController = new UserController();
        }
        
        return userController;
    }

    public UserDao getUserDao() {
        return userDao;
    }
    
    public void cadastrarUsuario(User user) throws UserExistenteException{
        getUserDao().cadastraUser(user);
    }
    
    public User buscarUser(String CPF) throws UserInexistenteException{
        return getUserDao().buscarUser(CPF);
    }
    
    public void editarUser(User user) throws UserInexistenteException{
        getUserDao().editarUser(user);
    }
    
    public void removerUser(String CPF) throws UserInexistenteException{
        getUserDao().removerUser(CPF);
    }
}
