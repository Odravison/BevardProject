/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.persistencia;

import br.unipe.cc.exceptions.SeguroExistenteException;
import br.unipe.cc.exceptions.EntidadeException;
import br.unipe.cc.exceptions.SeguroInexistenteException;
import br.unipe.cc.models.FiltrosAbstratos;
import br.unipe.cc.models.Seguro;
import br.unipe.cc.utils.MontadorDeClausulas;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
public class SeguroDao extends AbstractDao<Seguro> {

    @Inject
    private MontadorDeClausulas mount;

    /**
     * @param tipo
     */
    public SeguroDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void cadastraSeguro(Seguro seguro) throws SeguroExistenteException{
		super.salvar(seguro);
    }
    
   public void removerSeguro(Long id) throws SeguroInexistenteException {
		try {
			super.remover(id);
		} catch (EntidadeException e) {
			throw new SeguroInexistenteException(e.getMessage() + " : Seguro apagado");
		}
		
	}
   
   public List<Seguro> buscarSeguro(String CPFCliente) throws SeguroInexistenteException {
         String sql = "SELECT s FROM Seguro s ";

        HashMap<String, String> condicao = new HashMap<String, String>();
        condicao.put("s.cliente.CPF", CPFCliente);

        FiltrosAbstratos filtros = new FiltrosAbstratos(condicao);

        sql += mount.montarClausula(filtros);
        
        List<Seguro> seguros = super.buscarTodasEntidade(sql);
        
        if (seguros.isEmpty()) {
            throw new SeguroInexistenteException("Este cliente não possui seguro");
        }
        
        return seguros;

    }

public void editarSeguro(Seguro seguro) throws SeguroInexistenteException {
		try {
			super.editar(seguro);
		} catch (EntidadeException e) {
			throw new SeguroInexistenteException(e.getMessage() + " : Este seguro não existe");
		}
		
	}


}