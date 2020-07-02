/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.xaviersala.Vaca.Model;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tolsa
 */
class Ciutat {

    static int litresCiutat;
    private String nom;
    static double getPreuLlet(Camio camio) {
        double preuLlet = 1.1;
        List<Vaca> vaques =camio.getVaques();
        int litresCamio=0;
        for (Iterator<Vaca> iterator = vaques.iterator(); iterator.hasNext();) {
            Vaca next = iterator.next();
            litresCamio += next.getRaca().getLitresPerKg();
            //Aqui hauriem de fer càlculs per treure el preu de la llet
        }
        if (litresCamio%2==0)
            preuLlet +=0.1;
        else
            preuLlet -=0.1;
        return preuLlet;
    }

    static boolean getComproLlet() {
        return litresCiutat <= 1000;
    }

    Ciutat(String nom, int litresCiutat) {
        this.litresCiutat = litresCiutat;
        this.nom = nom;
    }


    
}
