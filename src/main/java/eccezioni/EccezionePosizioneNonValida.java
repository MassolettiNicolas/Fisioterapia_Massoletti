/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author nicio
 */
public class EccezionePosizioneNonValida extends Exception
{
    private int nVisitePresenti;
    private int maxVisite;

    public EccezionePosizioneNonValida(int nVisitePresenti, int maxVisite) 
    {
        this.nVisitePresenti=nVisitePresenti;
        this.maxVisite=maxVisite;
    }

    public int getnVisitePresenti() 
    {
        return nVisitePresenti;
    }

    public int getMaxVisite() 
    {
        return maxVisite;
    }     
    
    public String toString()
    {
        String s="";
        
        s="Il numero di visite presenti ("+getnVisitePresenti()+") eguaglia o supera il massimo di visite prenotabili ("+getMaxVisite()+")!";
        
        return s;
    }
}
