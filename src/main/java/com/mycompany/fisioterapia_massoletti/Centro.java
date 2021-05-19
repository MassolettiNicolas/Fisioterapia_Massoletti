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
    
    public Visita[] visualizzaVisite() throws EccezioneNessunaVisita
    {
        Visita[] arrayVisite=new Visita[getNVisitePresenti()];
        int c=0;
        
        for(int i=0;i<arrayVisite.length;i++)
        {
            if(calendarioVisite[i]!=null)
            {
                arrayVisite[c]=calendarioVisite[i];
                c++;
            }                
        }
        
        if(c==0)
            throw new EccezioneNessunaVisita(c);   //Nessuna prenotazione.
                   
        return arrayVisite;
    }
    
    //1 --> Registrare la prenotazione di una nuova visita.
    public void registraPrenotazione(Visita visita) throws EccezionePosizioneNonValida
    {
        try
        {
            calendarioVisite[nVisitePresenti]=visita;
            nVisitePresenti++;
        }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            throw new EccezionePosizioneNonValida(nVisitePresenti, NUM_MAX_VISITE);   //Posizione non valida.
        }   
    }
    
    //2 --> Eliminare una visita prenotata, più di un metodo.
    //CONTROLLARE L'ERRORE.
    //Mostra a schermo tutte le visite di un paziente e con il codice identificativo si sceglie quale eliminare.
    public int numeroPrenotazioniPaziente(String cognomePaziente, String nomePaziente) throws EccezioneNessunaVisita
    {
        int n=0;
        
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i]!=null && calendarioVisite[i].getCognome().compareToIgnoreCase(cognomePaziente)==0 && calendarioVisite[i].getNome().compareToIgnoreCase(nomePaziente)==0)
            {
                n++;
            }
        }
        
        if(n==0)
            throw new EccezioneNessunaVisita(n);   //Nessuna prenotazione.
        
        return n;
    }
    
    public Visita[] mostraPrenotazioni(String cognomePaziente, String nomePaziente, int lunghezzaArray) throws EccezioneNessunaVisita
    {
        int c=0;
        Visita[] arrayVisite=new Visita[lunghezzaArray];
        
        for(int i=0;i<arrayVisite.length;i++)
        {
            if(calendarioVisite[i]!=null && calendarioVisite[i].getCognome().compareToIgnoreCase(cognomePaziente)==0 && calendarioVisite[i].getNome().compareToIgnoreCase(nomePaziente)==0)
            {
                arrayVisite[c]=calendarioVisite[i];
                c++;
            }
        }
        
        if(c==0)
            throw new EccezioneNessunaVisita(c);   //Nessuna prenotazione.
        
        return arrayVisite;
    }
    
    public int rimuoviPrenotazione(int codiceID, Visita[] arrayVisite) throws EccezioneCodiceIdentificativo
    {
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(arrayVisite[i]!=null && arrayVisite[i].getCodiceIdentificativo()==codiceID)
            {
                aggiornaPosizione(i, arrayVisite);
                return 0;
            }
        }
        
        throw new EccezioneCodiceIdentificativo();   //Nessuna prenotazione per questo codice identificativo.
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
    //Controllo anche il codice identificativo perchè potrebbero esserci visite uguali.
    //VEDERE L'ERRORE.
    public String eseguiVisita(int codiceID, String nome, String cognome, int anno, int mese, int giorno, int ora, int minuto) throws EccezioneVisitaSvolta
    {
        String confronto="N";   //Controllo se la visita è già stata eseguita e se è vero, non la eseguo la seconda volta.
        String visitaScelta="";
        LocalDateTime confrontoVisita=null;   //CHIEDERE COME FARE.
        confrontoVisita.of(anno, mese, giorno, ora, minuto);
        
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i]!=null && calendarioVisite[i].getVisitaSvolta().compareToIgnoreCase(confronto)==0)
            {
                if(calendarioVisite[i].getCodiceIdentificativo()==codiceID && calendarioVisite[i].getAppuntamento().isEqual(confrontoVisita) && calendarioVisite[i].getCognome().compareToIgnoreCase(cognome)==0 && calendarioVisite[i].getNome().compareToIgnoreCase(nome)==0)
                {
                    calendarioVisite[i].setVisitaSvolta("S"); 
                    visitaScelta=calendarioVisite[i].toString();
                }
            } 
        }
        
        if(visitaScelta.compareToIgnoreCase("")==0)
            throw new EccezioneVisitaSvolta();   //Nessuna visita da svolgere con questi parametri.
        
        return visitaScelta;
    }
    
    //4 --> Visualizzare le visite di un determinato giorno.
    public Visita[] visualizzaPrenotazioniPerGiorno(int anno, int mese, int giorno) throws EccezioneNessunaVisita
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
            throw new EccezioneNessunaVisita(numeroVisitePerGiorno);   //Nessuna prenotazione.
        
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
    public Visita[] visualizzaVisiteNonSvolteOrdineAlfabetico() throws EccezioneNessunaVisita 
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
            throw new EccezioneNessunaVisita(numeroVisiteNonSvolte);   //Nessuna prenotazione.
        
        Visita[] elencoOrdinato=new Visita[numeroVisiteNonSvolte];
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
        //CONTROLLARE COME ORDINA.
        
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
