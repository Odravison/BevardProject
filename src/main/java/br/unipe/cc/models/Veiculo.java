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
        private Long ID;    // alterei de Long para String ----ATENÇÃO----
	private String ano;   // alterei de cor para ano
	private String alteracoesFeitas;
	private String chassi;
        private String placa;
	private String problemas;
        private String escuderia;
       	


	public Veiculo(String ano, String alteracoesFeitas, String chassi, String placa, String problemas, String escuderia) {
		this.ano = ano;                
                this.alteracoesFeitas = alteracoesFeitas;
		this.chassi = chassi;
                this.placa = placa;
                this.problemas = problemas;
                this.escuderia = escuderia;
		
               
               
	}

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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
