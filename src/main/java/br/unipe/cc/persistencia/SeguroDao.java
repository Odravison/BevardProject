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
   
   public void buscarUsuario(Long id) throws SeguroInexistenteException {
        try {
            super.buscarPorId(id);
        } catch (EntidadeException e) {
            throw new SeguroInexistenteException(e.getMessage() + " : Este seguro não existe");
        }

    }

public void editarSeguro(Seguro seguro) throws SeguroInexistenteException {
		try {
			super.editar(seguro);
		} catch (EntidadeException e) {
			throw new SeguroInexistenteException(e.getMessage() + " : Este seguro não existe");
		}
		
	}


}