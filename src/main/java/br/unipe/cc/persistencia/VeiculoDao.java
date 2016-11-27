/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.persistencia;

import br.unipe.cc.exceptions.EntidadeException;
import br.unipe.cc.exceptions.VeiculoInexistenteException;
import br.unipe.cc.exceptions.VeiculoExistenteException;
import br.unipe.cc.models.FiltrosAbstratos;
import br.unipe.cc.models.Veiculo;
import br.unipe.cc.utils.MontadorDeClausulas;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
public class VeiculoDao extends AbstractDao<Veiculo> {

    @Inject
    private MontadorDeClausulas mount;

    /**
     * @param tipo
     */
    public VeiculoDao() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void cadastraVeiculo(Veiculo veiculo) throws VeiculoExistenteException{
		String sql = "SELECT v FROM Veiculo v ";
		
		HashMap<String, String> condicao = new HashMap<String, String>();
		condicao.put("Placa", veiculo.getPlaca());
		
		FiltrosAbstratos filtros = new FiltrosAbstratos(condicao);
		
		sql += mount.montarClausula(filtros);
                
                if (!super.buscarTodasEntidade(sql).isEmpty()){
			throw new VeiculoExistenteException("Este veículo já está cadastrado");
		}
		super.salvar(veiculo);
    }
    
    public void removerVeiculo(Long id) throws VeiculoInexistenteException {
		try {
			super.remover(id);
		} catch (EntidadeException e) {
			throw new VeiculoInexistenteException(e.getMessage() + " : Veiculo apagado");
		}
		
	}
    
    public Veiculo buscarVeiculo(String Placa) throws VeiculoInexistenteException {
        String sql = "SELECT v FROM Veiculo v ";

        HashMap<String, String> condicao = new HashMap<String, String>();
        condicao.put("Placa", Placa);

        FiltrosAbstratos filtros = new FiltrosAbstratos(condicao);

        sql += mount.montarClausula(filtros);
        
        List<Veiculo> veiculos = super.buscarTodasEntidade(sql);
        
        if (veiculos.isEmpty()) {
            throw new VeiculoInexistenteException("Este cliente não está cadastrado");
        }
        
        return veiculos.get(0);

    }
    
    public void editarVeiculo(Veiculo veiculo) throws VeiculoInexistenteException {
		try {
			super.editar(veiculo);
		} catch (EntidadeException e) {
			throw new VeiculoInexistenteException(e.getMessage() + " : Este veículo não está cadastrado");
		}
		
	}


}