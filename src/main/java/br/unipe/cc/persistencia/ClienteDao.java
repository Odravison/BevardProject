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
import java.util.List;
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

    public void removerCliente(String CPF) throws ClienteInexistenteException {
        Cliente cliente = null;
        
        try {
            cliente = buscarCliente(CPF);
            if (cliente != null){
                remover(cliente.getId());
            }
        } catch (EntidadeException e) {
            throw new ClienteInexistenteException(e.getMessage() + " : Cliente não pôde ser apagado");
        }

    }

    public Cliente buscarCliente(String CPF) throws ClienteInexistenteException {
        
        String sql = "SELECT c FROM Cliente c ";

        HashMap<String, String> condicao = new HashMap<String, String>();
        condicao.put("CPF", CPF);

        FiltrosAbstratos filtros = new FiltrosAbstratos(condicao);

        sql += mount.montarClausula(filtros);
        
        List<Cliente> clientes = super.buscarTodasEntidade(sql);
        
        if (clientes.isEmpty()) {
            throw new ClienteInexistenteException("Este cliente não está cadastrado");
        }
        
        return clientes.get(0);

    }
    
    public void editarCliente(Cliente cliente) throws ClienteInexistenteException {
		try {
			super.editar(cliente);
		} catch (EntidadeException e) {
			throw new ClienteInexistenteException(e.getMessage() + " : Este cliente não está cadastrado");
		}
		
	}


}
