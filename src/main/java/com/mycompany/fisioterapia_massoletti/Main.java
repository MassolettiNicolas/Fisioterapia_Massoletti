/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

import java.util.*;

/**
 *
 * @author Nicolas
 */
public class Main 
{
    public static void main(String[] args) 
    {
        Visita v1=new Visita(1,"Massoletti","Nicolas","abcde","Esercizi Rinforzanti","Bonsi","Giuseppe",2021,5,12,15,15,"N");
        //Visita v2=new Visita(v1);
        Visita v2=new Visita(2,"m","n","dfbdb","ex","bonsi","giuse",2021,4,13,4,6,"S");
        Visita v3=new Visita();
        Visita v4=new Visita(3,"massoletti","nicolas","dfbdb","ex","bonsi","giuse",2021,4,13,4,6,"S");
        Visita v5=new Visita(4,"Massoletti","Nicolas","dfbdb","ex","bonsi","giuse",2021,4,13,4,6,"S");
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
        
        Centro c1=new Centro();
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
        System.out.println(c1.getNVisitePresenti());
        //Centro c1=new Centro();
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
        c1.registraPrenotazione(v4);
        c1.registraPrenotazione(v5);
        Visita[] arrayVisite=new Visita[c1.getNVisitePresenti()];
        c1.mostraPrenotazioni("Massoletti","Nicolas",arrayVisite);
        Scanner tastiera=new Scanner(System.in);
        int codice,easy;
        System.out.println("ins:");
        codice=tastiera.nextInt();
        easy=c1.rimuoviPrenotazione(codice,arrayVisite);
        if(easy==0)
            System.out.println("easy");
        else
            System.out.println("manai");
        for(int i=0;i<arrayVisite.length;i++)
        {
            if(arrayVisite[i]!=null)
                System.out.println(arrayVisite[i].toString());
        }       
        
        System.out.println(v1.toString()); 
    }
}
