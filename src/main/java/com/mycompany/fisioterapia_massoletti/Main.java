/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

import eccezioni.*;
import java.io.*;
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
        /*System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());*/
        
        Centro c1=new Centro();
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
        //System.out.println(c1.getNVisitePresenti());
        //Centro c1=new Centro();
        /*c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);*/
        c1.registraPrenotazione(v4);
        c1.registraPrenotazione(v5);
        //Visita[] arrayVisite=new Visita[c1.getNVisitePresenti()];
        //c1.mostraPrenotazioni("Massoletti","Nicolas",arrayVisite);
        /*Scanner tastiera=new Scanner(System.in);
        int codice,easy=0;
        System.out.println("ins:");
        codice=tastiera.nextInt();
        //easy=c1.rimuoviPrenotazione(codice,arrayVisite);
        if(easy==0)
            System.out.println("easy");
        else
            System.out.println("manai");
        for(int i=0;i<arrayVisite.length;i++)
        {
            if(arrayVisite[i]!=null)
                System.out.println(arrayVisite[i].toString());
        }      */ 
        
        //c1.visualizzaPrenotazioniPerGiorno(2021,4,13);
        /*String nomeFileCSV="visiteCentro.txt";
        try
        {
            c1.esportaLibri(nomeFileCSV);
            System.out.println("Esportazione avvenuta correttamente su file CSV!");
        }
        catch(IOException e1)
        {
            System.out.println("Impossibile accedere al file, i libri non sono stati salvati!");
        }
        catch(FileException e2)
        {
            System.out.println(e2.toString());
        }*/
        /*String nomeFileBinario="centro.bin";
        
        //Deserializzazione.
        try
        {
            c1=c1.caricaCentro(nomeFileBinario);
            System.out.println("Dati caricati correttamente!");
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Impossibile accedere al file, i dati non sono stati caricati!");
        }
        catch(FileException ex)
        {
            System.out.println("Errore di lettura, i dati non sono stati caricati!");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file!");
        }
        
        //Serializzazione.
        try 
        {
            c1.salvaCentro(nomeFileBinario);
            System.out.println("Dati salvati correttamente!");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file, i dati non sono stati salvati!");
        }*/
        
        /*Visita[] elenco;
        int anno=2021, mese=4, giorno=13;
        
        elenco=c1.visualizzaPrenotazioniPerGiorno(anno, mese, giorno);
        if(elenco==null)
            System.out.println("Nessuna prenotazione per questo giorno!");
        
        for(int i=0;i<elenco.length;i++)
        {
            System.out.println(elenco[i]);
        }*/
        
        /*String visitaScelta="";
        visitaScelta=c1.eseguiVisita(3, "Massoletti", "Nicolas", 2021, 4, 13, 4, 6);
        System.out.println(visitaScelta);*/
    }
}
