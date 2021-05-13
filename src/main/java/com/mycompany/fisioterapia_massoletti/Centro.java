/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

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
    }
}
