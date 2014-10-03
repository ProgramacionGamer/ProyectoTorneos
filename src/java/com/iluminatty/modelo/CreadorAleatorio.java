/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatty.modelo;

import com.iluminatty.basedatos.dao.TorneoDAO;
import com.iluminatty.basedatos.vo.TorneoVO;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CreadorAleatorio {

    
    public ArrayList<String> crearCodigosTorneo(TorneoVO torneo) {
        ArrayList<String> codigosAcceso = new ArrayList<>();
        String prefix = torneo.getPrefijo();
        Random ran = new Random();
        for (int i = 0; i < torneo.getNumeroJugadores(); i++) {
            String codigo = prefix;
            do {
                for (int j = 0; j < 10; j++) {
                    int c = 0;
                    do {
                        c = (ran.nextInt(74) + 48);
                    } while ((c < 97 && c > 90) || (c < 65 && c > 57));
                    codigo += (char) c;
                }
            } while (codigosAcceso.contains(codigo));
            codigosAcceso.add(codigo);

        }
        return codigosAcceso;
    }

}
