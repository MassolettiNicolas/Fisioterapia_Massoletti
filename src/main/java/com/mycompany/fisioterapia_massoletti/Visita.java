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
    public Visita(int codiceIdentificativo, String cognome, String nome, String CFPaziente, String descrizioneVisita, String cognomeFisioterapista, String nomeFisioterapista, int anno, int mese, int giorno, int ora, int minuto) 
    {
        //CHIEDERE SE IL CODICE IDENTIFICATIVO DEVE ESSERE ASSEGNATO AUTOMATICAMENTE O NO.
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
    public Visita()
    {
        //CHIEDERE SE E' GIUSTO METTERLO A 0.
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
    public int getCodiceIdentificativo()
    {
        return codiceIdentificativo;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public String getNome()
    {
        return nome;
    }

    public String getCFPaziente() 
    {
        return CFPaziente;
    }

    public String getDescrizioneVisita()
    {
        return descrizioneVisita;
    }

    public String getCognomeFisioterapista()
    {
        return cognomeFisioterapista;
    }

    public String getNomeFisioterapista()
    {
        return nomeFisioterapista;
    }

    public LocalDateTime getAppuntamento() 
    {
        return appuntamento;
    }

    public String getVisitaSvolta() 
    {
        return visitaSvolta;
    }
    
    //Setter.
    //CHIEDERE SE TENERLO OPPURE NO.
    public void setCodiceIdentificativo(int codiceIdentificativo)
    {
        this.codiceIdentificativo=codiceIdentificativo;
    }
    
    public void setCognome(String cognome)
    {
        this.cognome=cognome;
    }

    public void setNome(String nome) 
    {
        this.nome=nome;
    }

    public void setCFPaziente(String CFPaziente) 
    {
        this.CFPaziente=CFPaziente;
    }

    public void setDescrizioneVisita(String descrizioneVisita) 
    {
        this.descrizioneVisita=descrizioneVisita;
    }

    public void setCognomeFisioterapista(String cognomeFisioterapista) 
    {
        this.cognomeFisioterapista=cognomeFisioterapista;
    }

    public void setNomeFisioterapista(String nomeFisioterapista)
    {
        this.nomeFisioterapista=nomeFisioterapista;
    }

    public void setAppuntamento(int anno, int mese, int giorno, int ora, int minuto)
    {
        appuntamento.of(anno, mese, giorno, ora, minuto);
    }
    
    public void setVisitaSvolta(String visitaSvolta)
    {
        this.visitaSvolta=visitaSvolta;
    }
    
    //toString.
    //Override.
    public String toString()
    {
        String s="";
        
        s=getCodiceIdentificativo()+";"+getCognome()+";"+getNome()+";"+getCFPaziente()+";"+getDescrizioneVisita()+";"+getCognomeFisioterapista()+";"+getNomeFisioterapista()+";"+getAppuntamento()+";"+getVisitaSvolta()+";";
        
        return s;
    }
    
    //equals.
    //Override.
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
