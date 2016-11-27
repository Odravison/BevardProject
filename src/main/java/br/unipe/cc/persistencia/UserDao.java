/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.persistencia;

import br.unipe.cc.exceptions.EntidadeException;
import br.unipe.cc.exceptions.UserExistenteException;
import br.unipe.cc.exceptions.UserInexistenteException;
import br.unipe.cc.models.FiltrosAbstratos;
import br.unipe.cc.models.User;
import br.unipe.cc.utils.MontadorDeClausulas;
import java.util.HashMap;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
public class UserDao extends AbstractDao<User> {

    @Inject
    private MontadorDeClausulas mount;

    /**
     * @param tipo
     */
    public UserDao() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void cadastraUser(User user) throws UserExistenteException {
        String sql = "SELECT u FROM User u ";

        HashMap<String, String> condicao = new HashMap<String, String>();
        condicao.put("CPF", user.getCPF());

        FiltrosAbstratos filtros = new FiltrosAbstratos(condicao);

        sql += mount.montarClausula(filtros);

        if (!super.buscarTodasEntidade(sql).isEmpty()) {
            throw new UserExistenteException("Este usuário já está cadastrado");
        }
        super.salvar(user);
    }

    public void removerUser(Long id) throws UserInexistenteException {
        try {
            super.remover(id);
        } catch (EntidadeException e) {
            throw new UserInexistenteException(e.getMessage() + " : Usuário apagado");
        }

    }

    public void buscarUser(Long id) throws UserInexistenteException {
        try {
            super.buscarPorId(id);
        } catch (EntidadeException e) {
            throw new UserInexistenteException(e.getMessage() + " : Este usuário não está cadastrado");
        }

    }
    
    public void editarUser(User usuario) throws UserInexistenteException {
		try {
			super.editar(usuario);
		} catch (EntidadeException e) {
			throw new UserInexistenteException(e.getMessage() + " : Este usuário não está cadastrado");
		}
		
	}


}