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
    private static int NUM_MAX_VISITE=100;   
    private int nVisitePresenti;   
    //CHIEDERE SE PER DOCUMENTAZIONE VA BENE VISUALIZZA OPPURE RESTITUISCE UN ARRAY CHE...
    
    //Costruttore.
    /**
     * Costruttore della classe Centro. Inizializzo l'array di visite e inizializzo a 0 il numero di visite presenti.
     */
    public Centro()
    {
        calendarioVisite=new Visita[NUM_MAX_VISITE];
        this.nVisitePresenti=0;
    }
    
    //Getter.
    /**
     * Metodo getter statico che restituisce il numero massimo di visite presenti.
     * @return restituisce un intero che rappresenta il numero massimo di visite presenti.
     */
    public static int getNumMaxVisite()
    {
        return NUM_MAX_VISITE;
    }
    
    /**
     * Metodo getter che restituisce il numero di visite presenti.
     * @return restituisce un intero che rappresenta il numero di visite presenti.
     */
    public int getNVisitePresenti()
    {
        return nVisitePresenti;
    }
    
    /**
     * Metodo che consente di visualizzare tutte le visite prenotate.
     * @return restituisce un array che contiene tutte le visite presenti.
     * @throws EccezioneNessunaVisita eccezione che viene sollevata quando non è presente nessuna visita. 
     */
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
    /**
     * Metodo che consente di registrare una prenotazione.
     * @param visita passo come parametro una visita che sarà quella che verrà aggiunta.
     * @throws EccezionePosizioneNonValida eccezione che viene sollevata quando le visite presenti sono uguali 
     * o maggiori del numero massimo di prenotazioni possibili.
     */
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
    //CONTROLLARE L'ERRORE (NUOVO, SALVA SU FILE E SBAGLIA CODICE ID).
    //Mostra a schermo tutte le visite di un paziente e con il codice identificativo si sceglie quale eliminare.
    /**
     * Metodo che consente di contare il numero di prenotazioni di un determinato paziente con nome e cognome 
     * passati come parametro.
     * @param cognomePaziente cognome del paziente di cui si vogliono contare le prenotazioni presenti.
     * @param nomePaziente nome del paziente di cui si vogliono contare le prenotazioni presenti.
     * @return restituisce un intero che rappresenta il numero di prenotazioni di un determinato cliente.
     * @throws EccezioneNessunaVisita eccezione che viene sollevata quando non è presente nessuna visita.
     */
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
    
    /**
     * Metodo che costruisce un array di visite con lunghezza uguale al numero di visite che restituisce il metodo 
     * numeroPrenotazioniPaziente e lo riempie con le visite di un determinato paziente con nome e cognome 
     * passati come parametro.
     * @param cognomePaziente cognome del paziente di cui si vogliono inserire le prenotazioni.
     * @param nomePaziente nome del paziente di cui si vogliono inserire le prenotazioni.
     * @param lunghezzaArray valore intero che viene dato dal metodo numeroPrenotazioniPaziente e viene utilizzato
     * come lunghezza dell'array da restituire.
     * @return restituisce un array contenente le visite del paziente specificato come parametro.
     * @throws EccezioneNessunaVisita eccezione che viene sollevata quando non è presente nessuna visita.
     */
    public Visita[] mostraPrenotazioni(String cognomePaziente, String nomePaziente, int lunghezzaArray) throws EccezioneNessunaVisita
    {
        int c=0;
        Visita[] arrayVisite=new Visita[lunghezzaArray];
        
        for(int i=0;i<calendarioVisite.length;i++)
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
    
    /**
     * Metodo che elimina una prenotazione dell'array passato come parametro in base al 
     * codice identificativo passato anch'esso come parametro.
     * @param codiceID codice che identifica una specifica visita, in questo caso quella da eliminare.
     * @param arrayVisite array che contiene le visite di un determinato paziente.
     * @return restituisce un intero che indica se l'eliminazione è andata a buon fine.
     * @throws EccezioneCodiceIdentificativo eccezione che viene sollevata se, il codice identificativo passato
     * come parametro, non corrisponde a nessuna visita presente.
     */
    public int rimuoviPrenotazione(int codiceID, Visita[] arrayVisite) throws EccezioneCodiceIdentificativo
    {
        for(int i=0;i<arrayVisite.length;i++)
        {
            if(arrayVisite[i]!=null && arrayVisite[i].getCodiceIdentificativo()==codiceID)
            {
                aggiornaPosizione(i);
                return 0;
            }
        }
        
        throw new EccezioneCodiceIdentificativo();   //Nessuna prenotazione per questo codice identificativo.
    }
    
    /**
     * Metodo che "sposta" le visite presenti nell'array indietro di una posizione.
     * @param posizione valore intero che rappresenta la posizione in cui si trova la visita da eliminare.
     */
    private void aggiornaPosizione(int posizione)
    {
        for(int i=posizione;i<getNVisitePresenti()-1;i++)
        {
            if(calendarioVisite[i]!=null)
            {
                calendarioVisite[i]=calendarioVisite[i+1];
            }  
        }
        
        nVisitePresenti--;
    }
 
    //3 --> Eseguire una visita.
    //Controllo anche il codice identificativo perchè potrebbero esserci visite uguali.
    /**
     * Metodo che simula l'esecuzione di una visita impostando l'attributo visitaSvolta su "S".
     * @param codiceID codice identificativo della visita da eseguire.
     * @param nome nome del paziente della visita da eseguire.
     * @param cognome cognome del paziente della visita da eseguire.
     * @param anno anno della visita da eseguire.
     * @param mese mese della visita da eseguire.
     * @param giorno giorno della visita da eseguire.
     * @param ora ora della visita da eseguire.
     * @param minuto minuto della visita da eseguire.
     * @return restituisce una stringa che corrisponde al toString della visita corrispondente ai parametri passati con
     * l'attributo visitaSvolta uguale ad S.
     * @throws EccezioneVisitaSvolta eccezione che viene sollevata se non c'è nessuna visita che corrisponde ai parametri
     * passati.
     */
    public String eseguiVisita(int codiceID, String nome, String cognome, int anno, int mese, int giorno, int ora, int minuto) throws EccezioneVisitaSvolta
    {
        String confronto="N";   //Controllo se la visita è già stata eseguita e se è vero, non la eseguo la seconda volta.
        String visitaScelta="";
        LocalDateTime confrontoVisita=null;   //CHIEDERE COME FARE.
        confrontoVisita=confrontoVisita.of(anno, mese, giorno, ora, minuto);
        
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
    /**
     * Metodo che consente di visualizzare tutte le prenotazioni per un determinato giorno.
     * @param anno anno che devono avere le visite.
     * @param mese mese che devono avere le visite.
     * @param giorno giorno che devono avere le visite.
     * @return restituisce un array di visite contenente tutte le visite presenti per quel determinato giorno.
     * @throws EccezioneNessunaVisita eccezione che viene sollevata quando non è presente nessuna visita per quel 
     * determinato giorno.
     */
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
    /**
     * Metodo che consente di visualizzare tutte le visite non ancora svolte in ordine alfabetico di cognome, poi nome
     * nel caso il cognome fosse uguale, poi codice fiscale e così per tutti gli attributi.
     * @return restituisce un array di visite già ordinato contenente tutte le visite non svolte.
     * @throws EccezioneNessunaVisita eccezione che viene sollevata quando non è presente nessuna visita non svolta.
     */
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
        
        return elencoOrdinato;
    }
    
    /**
     * Metodo che consente di assegnare il codice identificativo ad ogni visita presente ogni volta che vengono caricate
     * da file.
     * @param i indica la visita a cui dev'ssere assegnato il codice.
     * @param codiceID indica il codice identificativo da assegnare alla visita.
     */
    public void setCodiceIdentificativo(int i, int codiceID)
    {
        calendarioVisite[i].setCodiceIdentificativo(codiceID);
    }
    
    //6 --> Esportare in CSV le visite presenti.
    /**
     * Metodo che consente di esportare tutte le visite presenti su di un file CSV.
     * @param nomeFile il nome del file CSV su cui esportare le visite.
     * @throws IOException eccezione che viene sollevata quando risulta impossibile accedere al file.
     * @throws FileException eccezione che viene sollevata quando non si riesce ad utilizzare un metodo del file.
     */
    public void esportaVisiteCSV(String nomeFile) throws IOException, FileException 
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
    /**
     * Metodo che consente di salvare i dati su di un file binario.
     * @param nomeFile nome del file binario su cui vanno salvati i dati.
     * @throws FileNotFoundException eccezione che viene sollevata quando non si trova il file o comunque quando non 
     * si riesce ad accedervi.
     * @throws IOException eccezione che viene sollevata quando risulta impossibile accedere al file.
     */
    public void salvaVisite(String nomeFile) throws FileNotFoundException, IOException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream outputStream=new ObjectOutputStream(f1); 
        outputStream.writeObject(this);   //Serializzo questo stesso centro, scrivo questo centro su di un file binario.
        outputStream.flush();
        outputStream.close();
    }
    
    //Carica dati.
    /**
     * Metodo che consente di caricare i dati da un file binario.
     * @param nomeFile nome del file binario da cui vanno caricati i dati.
     * @return restituisce un Centro che contiene tutte le visite che vengono caricate dal file.
     * @throws FileNotFoundException eccezione che viene sollevata quando non si trova il file o comunque quando non 
     * si riesce ad accedervi.
     * @throws IOException eccezione che viene sollevata quando risulta impossibile accedere al file.
     * @throws FileException eccezione che viene sollevata quando non si riesce ad utilizzare un metodo del file.
     */
    public Centro caricaVisite(String nomeFile) throws FileNotFoundException, IOException, FileException
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
    
    //toString.
    //Override.
    /**
     * Metodo che consente di visualizzare tutte le visite presenti con tutti i loro attributi.
     * @return restituisce una stringa che contiene tutte le visite con i loro attributi.
     */
    public String toString()
    {
        String s="";
        
        for(int i=0;i<calendarioVisite.length;i++)
        {
            if(calendarioVisite[i]!=null)
            {
                s=s+calendarioVisite[i].toString()+"\n";
            }
        }
        
        return s;
    }
}
