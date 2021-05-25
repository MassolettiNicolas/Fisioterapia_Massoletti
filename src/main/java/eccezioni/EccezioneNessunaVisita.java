/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author Nicolas
 */
public class EccezioneNessunaVisita extends Exception 
{
    private int nVisite;

    public EccezioneNessunaVisita(int nVisite)
    {
        this.nVisite=nVisite;
    }

    public int getnVisite() 
    {
        return nVisite;
    }
    
    public String toString()
    {
        String s="";
        
        s="Non e' presente nessuna visita! Numero Prenotazioni --> "+getnVisite();
        
        return s;
    }
}