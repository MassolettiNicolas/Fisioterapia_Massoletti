/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

import java.io.*;
import java.time.*;

/**
 *
 * @author Nicolas
 */
public class Visita implements Serializable 
{
    //Attributi.
    private int codiceIdentificativo;   //Un codice numerico univoco per ogni paziente.
    private String cognome;   //Cognome del paziente.
    private String nome;   //Nome del paziente.
    private String CFPaziente;   //Codice fiscale del paziente.
    private String descrizioneVisita;   //Esempio: massaggio defaticante ecc...
    private String cognomeFisioterapista;
    private String nomeFisioterapista;
    private LocalDateTime appuntamento;   //Data ed ora della visita.
    private String visitaSvolta;   //Visita svolta: si/no.
    
    //Costruttore.
    /**
     * Costruttore della classe Visita. Inizializzo tutti gli attributi assegnandovi un valore.
     * @param codiceIdentificativo codice univoco che identifica una visita.
     * @param cognome cognome del paziente.
     * @param nome nome del paziente.
     * @param CFPaziente codice fiscale del paziente.
     * @param descrizioneVisita descrizione della visita, se massaggio, controllo o qualsiasi terapia.
     * @param cognomeFisioterapista cognome del fisioterapista.
     * @param nomeFisioterapista nome del fisioterapista.
     * @param anno anno della visita.
     * @param mese mese della visita.
     * @param giorno giorno della visita.
     * @param ora ora della visita.
     * @param minuto minuto della visita.
     */
    public Visita(int codiceIdentificativo, String cognome, String nome, String CFPaziente, String descrizioneVisita, String cognomeFisioterapista, String nomeFisioterapista, int anno, int mese, int giorno, int ora, int minuto) 
    {
        this.codiceIdentificativo=codiceIdentificativo;
        this.cognome=cognome;
        this.nome=nome;
        this.CFPaziente=CFPaziente;
        this.descrizioneVisita=descrizioneVisita;
        this.cognomeFisioterapista=cognomeFisioterapista;
        this.nomeFisioterapista=nomeFisioterapista;
        this.appuntamento=LocalDateTime.of(anno, mese, giorno, ora, minuto);
        this.visitaSvolta="N";   
    }
    
    //Costruttore di copia.
    /**
     * Costruttore di copia. Inizializzo gli attributi assegnandovi il valore corrispondente allo stesso attributo di 
     * un altro oggetto Visita passato come parametro.
     * @param visita oggetto Visita che viene utilizzato per inizializzare gli attributi del nuovo oggetto Visita.
     */
    public Visita(Visita visita)
    {
        codiceIdentificativo=visita.getCodiceIdentificativo();
        cognome=visita.getCognome();
        nome=visita.getNome();
        CFPaziente=visita.getCFPaziente();
        descrizioneVisita=visita.getDescrizioneVisita();
        cognomeFisioterapista=visita.getCognomeFisioterapista();
        nomeFisioterapista=visita.getNomeFisioterapista();
        appuntamento=visita.getAppuntamento();
        visitaSvolta=visita.getVisitaSvolta();
    }
    
    //Costruttore di default.
    /**
     * Costruttore di default. Inizializzo tutti gli attributi a zero se sono numerici, vuoti se sono dei caratteri 
     * oppure a questo istante se sono LocalDateTime.
     */
    public Visita()
    {
        codiceIdentificativo=0;
        cognome="";
        nome="";
        CFPaziente="";
        descrizioneVisita="";
        cognomeFisioterapista="";
        nomeFisioterapista="";
        appuntamento=LocalDateTime.now();   //Istanzia un oggetto con data ed ora correnti.
        visitaSvolta="N"; 
    }
    
    //Metodi.
    //Getter.
    /**
     * Metodo getter che restituisce il codice identificativo della visita.
     * @return restituisce un intero che rappresenta il codice identificativo della visita.
     */
    public int getCodiceIdentificativo()
    {
        return codiceIdentificativo;
    }
    
    /**
     * Metodo getter che restituisce il cognome del paziente della visita.
     * @return restituisce una stringa che rappresenta il cognome del paziente della visita.
     */
    public String getCognome() 
    {
        return cognome;
    }
    
    /**
     * Metodo getter che restituisce il nome del paziente della visita.
     * @return restituisce una stringa che rappresenta il nome del paziente della visita.
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     * Metodo getter che restituisce il codice fiscale del paziente della visita.
     * @return restituisce una stringa che rappresenta il codice fiscale del paziente della visita.
     */
    public String getCFPaziente() 
    {
        return CFPaziente;
    }
    
    /**
     * Metodo getter che restituisce la tipologia di terapia del paziente della visita.
     * @return restituisce una stringa che rappresenta la tipologia di terapia del paziente della visita.
     */
    public String getDescrizioneVisita()
    {
        return descrizioneVisita;
    }
    
    /**
     * Metodo getter che restituisce il cognome del fisioterapista della visita.
     * @return restituisce una stringa che rappresenta il cognome del fisioterapista della visita.
     */
    public String getCognomeFisioterapista()
    {
        return cognomeFisioterapista;
    }
    
    /**
     * Metodo getter che restituisce il nome del fisioterapista della visita.
     * @return restituisce una stringa che rappresenta il nome del fisioterapista della visita.
     */
    public String getNomeFisioterapista()
    {
        return nomeFisioterapista;
    }
    
    /**
     * Metodo getter che restituisce la data e l'orario della visita.
     * @return restituisce un LocalDateTime che rappresenta la data e l'orario della visita.
     */
    public LocalDateTime getAppuntamento() 
    {
        return appuntamento;
    }
    
    /**
     * Metodo getter che restituisce lo stato (svolta oppure no) della visita.
     * @return restituisce una stringa che rappresenta lo stato (svolta oppure no) della visita.
     */
    public String getVisitaSvolta() 
    {
        return visitaSvolta;
    }
    
    //Setter. 
    /**
     * Metodo che consente di assegnare il codice identificativo alla visita.
     * @param codiceIdentificativo indica il codice da dover assegnare alla visita.
     */
    public void setCodiceIdentificativo(int codiceIdentificativo)
    {
        this.codiceIdentificativo=codiceIdentificativo;
    }
    
    /**
     * Metodo che consente di assegnare il cognome del paziente alla visita.
     * @param cognome indica il cognome del paziente da dover assegnare alla visita.
     */
    public void setCognome(String cognome)
    {
        this.cognome=cognome;
    }
    
    /**
     * Metodo che consente di assegnare il nome del paziente alla visita.
     * @param nome indica il nome del paziente da dover assegnare alla visita.
     */
    public void setNome(String nome) 
    {
        this.nome=nome;
    }
    
    /**
     * Metodo che consente di assegnare il codice fiscale del paziente alla visita.
     * @param CFPaziente indica il codice fiscale del paziente da dover assegnare alla visita.
     */
    public void setCFPaziente(String CFPaziente) 
    {
        this.CFPaziente=CFPaziente;
    }
    
    /**
     * Metodo che consente di assegnare la tipologia di terapia del paziente alla visita.
     * @param descrizioneVisita indica la tipologia di terapia del paziente da dover assegnare alla visita.
     */
    public void setDescrizioneVisita(String descrizioneVisita) 
    {
        this.descrizioneVisita=descrizioneVisita;
    }
    
    /**
     * Metodo che consente di assegnare il cognome del fisioterapista alla visita.
     * @param cognomeFisioterapista indica il cognome del fisioterapista da dover assegnare alla visita.
     */
    public void setCognomeFisioterapista(String cognomeFisioterapista) 
    {
        this.cognomeFisioterapista=cognomeFisioterapista;
    }
    
    /**
     * Metodo che consente di assegnare il nome del fisioterapista alla visita.
     * @param nomeFisioterapista indica il nome del fisioterapista da dover assegnare alla visita.
     */
    public void setNomeFisioterapista(String nomeFisioterapista)
    {
        this.nomeFisioterapista=nomeFisioterapista;
    }
    
    /**
     * Metodo che consente di assegnare una data ed un'ora alla visita.
     * @param anno anno della visita.
     * @param mese mese della visita.
     * @param giorno giorno della visita.
     * @param ora ora della visita.
     * @param minuto minuto della visita.
     */
    public void setAppuntamento(int anno, int mese, int giorno, int ora, int minuto)
    {
        this.appuntamento=this.appuntamento.of(anno, mese, giorno, ora, minuto);
    }
    
    /**
     * Metodo che consente di assegnare lo stato (svolta oppure no) alla visita.
     * @param visitaSvolta indica lo stato (svolta oppure no) da dover assegnare alla visita.
     */
    public void setVisitaSvolta(String visitaSvolta)
    {
        this.visitaSvolta=visitaSvolta;
    }
    
    //toString.
    //Override.
    /**
     * Metodo che consente di visualizzare tutti gli attributi della visita grazie ai rispettivi metodi getter
     * (metodo ridefinito, override).
     * @return restituisce una stringa che contiene tutti gli attributi della visita.
     */
    @Override
    public String toString()
    {
        String s="";
        
        s=getCodiceIdentificativo()+";"+getCognome()+";"+getNome()+";"+getCFPaziente()+";"+getDescrizioneVisita()+";"+getCognomeFisioterapista()+";"+getNomeFisioterapista()+";"+getAppuntamento()+";"+getVisitaSvolta()+";";
        
        return s;
    }
    
    //equals.
    //Override.
    /**
     * Metodo che consente di confrontare due oggetti e di stabilire se essi sono uguali (tutti gli attributi 
     * uguali, metodo ridefinito, override) o meno.
     * @param o riceve come parametro un oggetto che verrà "trasformato" in una Visita che sarà utilizzata per il confronto.
     * @return restituisce un valore booleano che può essere true nel caso i due oggetti siano uguali, false nel caso siano diversi.
     */
    @Override
    public boolean equals(Object o)
    {
        Visita visita;
        visita=(Visita)o;
        if(this.getCodiceIdentificativo()==visita.getCodiceIdentificativo() && this.cognome.compareToIgnoreCase(visita.getCognome())==0 && this.nome.compareToIgnoreCase(visita.getNome())==0 && this.CFPaziente.compareToIgnoreCase(visita.getCFPaziente())==0 && this.descrizioneVisita.compareToIgnoreCase(visita.getDescrizioneVisita())==0 && this.cognomeFisioterapista.compareToIgnoreCase(visita.getCognomeFisioterapista())==0 && this.nomeFisioterapista.compareToIgnoreCase(visita.getNomeFisioterapista())==0 && this.appuntamento.isEqual(visita.getAppuntamento()) && this.visitaSvolta.compareToIgnoreCase(visita.getVisitaSvolta())==0)
            return true;
        else 
            return false;
    }
}