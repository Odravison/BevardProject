/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.utils;

import br.unipe.cc.models.FiltrosAbstratos;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class MontadorDeClausulas {

    public String montarClausula(FiltrosAbstratos filtros) {
        String where = "";

        if (!filtros.getFiltros().isEmpty()) {
            where = "WHERE ";

            Iterator it = (Iterator) filtros.getFiltros().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry par = (Map.Entry) it.next();

                //Esse trecho de código verifica que tipo de	 parâmetro é.
                if (par.getValue() instanceof String) {

                    where += par.getKey() + " = '" + par.getValue() + "'";

                } else if (par.getValue() instanceof Date) {

                    where += par.getKey() + " = " + ((Date) par.getValue()).getTime();

                } else if (par.getValue() instanceof Double) {

                    where += par.getKey() + " BETWEEN " + par.getValue() + " AND ";
                    Map.Entry parAux = (Map.Entry) it.next();
                    where += parAux.getValue();

                } else {

                    where += par.getKey() + " = " + par.getValue();
                }

                //Esse if verifica se existe mais parâmetros a serem adicionados
                //Para que possa ser adicionado um 'AND' entre cada parâmetro.
                if (it.hasNext()) {
                    where += " AND ";
                }

            }

        }

        return where;

    }

}
