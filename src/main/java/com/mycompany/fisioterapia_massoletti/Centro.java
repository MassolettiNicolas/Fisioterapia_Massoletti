/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

import altro.Ordinatore;

/**
 *
 * @author Nicolas
 */
public class Centro 
{
    //Attributi.
    private Visita[] calendarioVisite;
    private static int NUM_MAX_VISITE=100;   //CHIEDERE SE 100.
    private int nVisitePresenti;   //CHIEDERE SE SERVE.
    
    //Costruttore.
    public Centro()
    {
        calendarioVisite=new Visita[NUM_MAX_VISITE];
    }
    
    /*//Costruttore di copia.
    public Centro(Centro centro)
    {
        calendarioVisite=new Visita[NUM_MAX_VISITE];
        
        for(int i=0;i<getNumMaxVisite();i++)
        {
            calendarioVisite[i]=centro.getVisita(i);
        }
    }*/
    
    //Costruttore di default.
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
    //RIGUARDARE I METODI DI ELIMINA.
    /*public void mostraPrenotazioni(String cognomePaziente, String nomePaziente, Visita[] arrayVisite)
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
                aggiornaPosizione(i);
                aggiornaPosizioneArrayPaziente(i,arrayVisite);
                return 0;
            }
        }
        
        return -1;
    }
    
    private void aggiornaPosizione(int posizione)
    {
        for(int i=posizione;i<getNVisitePresenti()-1;i++)
        {
            calendarioVisite[i]=calendarioVisite[i+1];
        }
        
        nVisitePresenti--;
    }
    
    private void aggiornaPosizioneArrayPaziente(int posizione, Visita[] arrayVisite)
    {
        for(int i=posizione;i<getNVisitePresenti()-1;i++)
        {
            arrayVisite[i]=arrayVisite[i+1];
        }
        
        nVisitePresenti--;
    }*/
    
    //3 --> Eseguire una visita.
    //CHIEDERE COME SI SCEGLIE LA VISITA DA ESEGUIRE.
    
    //4 --> Visualizzare le visite di un determinato giorno.
    //CHIEDERE SE VA BENE FARE SOUT QUI OPPURE NO (SE NO RESTITUISCI UNA STRINGA COSTRUITA CON s+=calendarioVisite[i].toString()).
    public void visualizzaPrenotazioniPerGiorno(int anno, int mese, int giorno)
    {
        for(int i=0;i<getNVisitePresenti();i++)
        {
            if(calendarioVisite[i].getAppuntamento().getYear()==anno && calendarioVisite[i].getAppuntamento().getMonthValue()==mese && calendarioVisite[i].getAppuntamento().getDayOfMonth()==giorno)
            {
                System.out.println(calendarioVisite[i].toString());
            }
        }
    }
    
    //5 --> Visualizzare le visite non ancora svolte in ordine alfabetico per paziente.
    //CHIEDERE SE VA BENE FARE SOUT QUI OPPURE NO (SE NO RESTITUISCI UNA STRINGA COSTRUITA CON s+=elencoOrdinato[j].toString()).
    public void visualizzaVisiteNonSvolteOrdineAlfabetico()
    {
        Visita[] elencoOrdinato=new Visita[getNVisitePresenti()];
        int c=0;
        String confronto="N";   //La stringa che utilizzo per confrontare.
        
        for(int i=0;i<elencoOrdinato.length;i++)
        {
            if(calendarioVisite[i]!=null && calendarioVisite[i].getVisitaSvolta().compareToIgnoreCase(confronto)==0)
            {
                elencoOrdinato[c]=calendarioVisite[i];
                c++;
            }
        }
        
        elencoOrdinato=Ordinatore.selectionSortAlfabeticoVisiteNonSvolte(elencoOrdinato);
        
        for(int j=0;j<elencoOrdinato.length;j++)
            System.out.println(elencoOrdinato[j].toString());
    }
}
