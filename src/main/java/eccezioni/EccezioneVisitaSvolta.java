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
public class EccezioneVisitaSvolta extends Exception
{
    public EccezioneVisitaSvolta() 
    {
        
    }
    
    public String toString()
    {
        String s="";
        
        s="Non e' presente nessuna visita da eseguire con questi parametri oppure è già stata eseguita!";
        
        return s;
    }
}
