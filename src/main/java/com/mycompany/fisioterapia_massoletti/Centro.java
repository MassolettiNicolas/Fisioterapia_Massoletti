/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

import altro.*;
import eccezioni.*;
import file.*;
import java.io.*;
import java.time.*;

/**
 *
 * @author Nicolas
 */
public class Centro implements Serializable
{
    //Attributi.
    private Visita[] calendarioVisite;
    private static int NUM_MAX_VISITE=100;   //CHIEDERE SE 100.
    private int nVisitePresenti;   
    
    //Costruttore.
    public Centro()
    {
        calendarioVisite=new Visita[NUM_MAX_VISITE];
    }
    
    //Getter.
    public static int getNumMaxVisite()
    {
        return NUM_MAX_VISITE;
    }
    
    public int getNVisitePresenti()
    {
        return nVisitePresenti;
    }
    
    //1 --> Registrare la prenotazione di una nuova visita.
    public int registraPrenotazione(Visita visita)
    {
        if(getNVisitePresenti()<=getNumMaxVisite())
        {
            calendarioVisite[nVisitePresenti]=visita;
            nVisitePresenti++;
            return 0;
        }
        else
            return -1;
    }
    
    //2 --> Eliminare una visita prenotata, più di un metodo.
    public void mostraPrenotazioni(String cognomePaziente, String nomePaziente, Visita[] arrayVisite)
    {
        int c=0;
        
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i].getCognome().compareToIgnoreCase(cognomePaziente)==0 && calendarioVisite[i].getNome().compareToIgnoreCase(nomePaziente)==0)
            {
                System.out.println(calendarioVisite[i].toString());
                arrayVisite[c]=calendarioVisite[i];
                c++;
            }
        }
    }
    
    public int rimuoviPrenotazione(int codiceID, Visita[] arrayVisite)
    {
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(arrayVisite[i]!=null && arrayVisite[i].getCodiceIdentificativo()==codiceID)
            {
                aggiornaPosizione(i, arrayVisite);
                return 0;
            }
        }
        
        return -1;
    }
    
    private void aggiornaPosizione(int posizione, Visita[] arrayVisite)
    {
        for(int i=posizione;i<getNVisitePresenti()-1;i++)
        {
            calendarioVisite[i]=calendarioVisite[i+1];
            arrayVisite[i]=arrayVisite[i+1];
        }
        
        nVisitePresenti--;
    }
 
    //3 --> Eseguire una visita.
    //Controllo anche il codice identificativo nel caso ci fossero visite uguali.
    //CONTROLLARE L'ERRORE CHE DA IL METODO NEL COMPILARE.
    /*public String eseguiVisita(int codiceID, String nome, String cognome, int anno, int mese, int giorno, int ora, int minuto)
    {
        String visitaScelta="";
        LocalDateTime confrontoVisita=null;
        confrontoVisita.of(anno, mese, giorno, ora, minuto);
        
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i]!=null)
            {
                if(calendarioVisite[i].getCodiceIdentificativo()==codiceID && calendarioVisite[i].getAppuntamento().isEqual(confrontoVisita) && calendarioVisite[i].getCognome().compareToIgnoreCase(cognome)==0 && calendarioVisite[i].getNome().compareToIgnoreCase(nome)==0)
                {
                    calendarioVisite[i].setVisitaSvolta("S"); 
                    visitaScelta=calendarioVisite[i].toString();
                }
            } 
        }
        
        return visitaScelta;
    }*/
    
    //4 --> Visualizzare le visite di un determinato giorno.
    public Visita[] visualizzaPrenotazioniPerGiorno(int anno, int mese, int giorno)
    {
        int numeroVisitePerGiorno=0;
        
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i]!=null && calendarioVisite[i].getAppuntamento().getYear()==anno && calendarioVisite[i].getAppuntamento().getMonthValue()==mese && calendarioVisite[i].getAppuntamento().getDayOfMonth()==giorno)
            {
                numeroVisitePerGiorno++;
            }
        }
        
        //Se non ci sono visite per quel giorno --> return null.
        if(numeroVisitePerGiorno==0)
            return null;
        
        Visita[] elencoVisitePerGiorno=new Visita[numeroVisitePerGiorno];
        
        int posizioneVisita=0;
        
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i]!=null && calendarioVisite[i].getAppuntamento().getYear()==anno && calendarioVisite[i].getAppuntamento().getMonthValue()==mese && calendarioVisite[i].getAppuntamento().getDayOfMonth()==giorno)
            {
                elencoVisitePerGiorno[posizioneVisita]=calendarioVisite[i];
                posizioneVisita++;
            }
        }
        
        return elencoVisitePerGiorno;
    }
    
    //5 --> Visualizzare le visite non ancora svolte in ordine alfabetico per paziente.
    public Visita[] visualizzaVisiteNonSvolteOrdineAlfabetico()
    {
        String confronto="N";   //La stringa che utilizzo per confrontare.
        int numeroVisiteNonSvolte=0;
        
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i]!=null && calendarioVisite[i].getVisitaSvolta().compareToIgnoreCase(confronto)==0)
            {
                numeroVisiteNonSvolte++;
            }
        }
        
        //Se non ci sono visite non svolte --> return null.
        if(numeroVisiteNonSvolte==0)
            return null;
        
        Visita[] elencoOrdinato=new Visita[getNVisitePresenti()];
        int posizione=0;       
        
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i]!=null && calendarioVisite[i].getVisitaSvolta().compareToIgnoreCase(confronto)==0)
            {
                elencoOrdinato[posizione]=calendarioVisite[i];
                posizione++;
            }
        }
        
        elencoOrdinato=Ordinatore.selectionSortAlfabeticoVisiteNonSvolte(elencoOrdinato);
        
        return elencoOrdinato;
    }
    
    //6 --> Esportare in CSV.
    public void esportaLibri(String nomeFile) throws IOException, FileException 
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Visita visita;
        
        for(int i=0;i<calendarioVisite.length;i++)
        {
            visita=calendarioVisite[i];
            if(visita!=null)
            {
                f1.toFile(visita.getCodiceIdentificativo()+";"+visita.getCognome()+";"+visita.getNome()+";"+visita.getCFPaziente()+";"+visita.getDescrizioneVisita()+";"+visita.getCognomeFisioterapista()+";"+visita.getNomeFisioterapista()+";"+visita.getAppuntamento()+";"+visita.getVisitaSvolta()+";"); 
            }
        }
        
        f1.close();
    }
    
    //7 --> Salva dati su file binario e carica all'avvio del software.
    //Serializzazione su file binario.
    //Salva dati.
    public void salvaCentro(String nomeFile) throws FileNotFoundException, IOException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream outputStream=new ObjectOutputStream(f1); 
        outputStream.writeObject(this);   //Serializzo questo stesso centro, scrivo questo centro su di un file binario.
        outputStream.flush();
        outputStream.close();
    }
    
    //Carica dati.
    public Centro caricaCentro(String nomeFile) throws FileNotFoundException, IOException, FileException
    {
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream inputStream=new ObjectInputStream(f1); 
        Centro c;
        try 
        {
            c=(Centro)inputStream.readObject();
            inputStream.close();
            return c;
        } 
        catch (ClassNotFoundException ex) 
        {
            inputStream.close();
            throw new FileException("Errore nella lettura del file!");
        }
    }
}
