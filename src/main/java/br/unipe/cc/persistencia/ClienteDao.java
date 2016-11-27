/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.persistencia;

import br.unipe.cc.exceptions.EntidadeException;
import br.unipe.cc.exceptions.ClienteExistenteException;
import br.unipe.cc.exceptions.ClienteInexistenteException;
import br.unipe.cc.models.FiltrosAbstratos;
import br.unipe.cc.models.Cliente;
import br.unipe.cc.utils.MontadorDeClausulas;
import java.util.HashMap;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
public class ClienteDao extends AbstractDao<Cliente> {

    @Inject
    private MontadorDeClausulas mount;

    /**
     * @param tipo
     */
    public ClienteDao() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void cadastraCliente(Cliente cliente) throws ClienteExistenteException {
        String sql = "SELECT c FROM Cliente c ";

        HashMap<String, String> condicao = new HashMap<String, String>();
        condicao.put("CPF", cliente.getCPF());

        FiltrosAbstratos filtros = new FiltrosAbstratos(condicao);

        sql += mount.montarClausula(filtros);

        if (!super.buscarTodasEntidade(sql).isEmpty()) {
            throw new ClienteExistenteException("Este cliente já está cadastrado");
        }
        super.salvar(cliente);
    }

    public void removerCliente(Long id) throws ClienteInexistenteException {
        try {
            super.remover(id);
        } catch (EntidadeException e) {
            throw new ClienteInexistenteException(e.getMessage() + " : Cliente apagado");
        }

    }

    public void buscarCliente(Long id) throws ClienteInexistenteException {
        try {
            super.buscarPorId(id);
        } catch (EntidadeException e) {
            throw new ClienteInexistenteException(e.getMessage() + " : Este cliente não está cadastrado");
        }

    }
    
    public void editarCliente(Cliente cliente) throws ClienteInexistenteException {
		try {
			super.editar(cliente);
		} catch (EntidadeException e) {
			throw new ClienteInexistenteException(e.getMessage() + " : Este cliente não está cadastrado");
		}
		
	}


}
