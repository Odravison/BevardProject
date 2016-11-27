/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.models;

/**
 *
 * @author Felipe
 */
public class Veiculo extends EntidadePersistivel{
        private Long ID;
	private String cor;
	private String alteracoesFeitas;
	private String chassi;
        private String placa;
	private String problemas;
       	


	public Veiculo(String alteracoesFeitas,String cor, String placa, String chassi) {
		this.cor = cor;
		this.placa = placa;
		this.chassi = chassi;
                this.alteracoesFeitas = alteracoesFeitas;
               
	}

	public Veiculo(String alteracoesFeitas,String cor, String placa, String chassi, String alteracoes) {
		this.cor = cor;
		this.placa = placa;
		this.chassi = chassi;
		this.alteracoesFeitas = alteracoes;
                this.alteracoesFeitas = alteracoesFeitas;
        }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAlteracoes() {
        return alteracoesFeitas;
    }

    public void setAlteracoes(String alteracoes) {
        this.alteracoesFeitas = alteracoes;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getProblemas() {
        return problemas;
    }

    public void setProblemas(String problemas) {
        this.problemas = problemas;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAlteracoesFeitas() {
        return alteracoesFeitas;
    }

    public void setAlteracoesFeitas(String alteracoesFeitas) {
        this.alteracoesFeitas = alteracoesFeitas;
    }

    
}
