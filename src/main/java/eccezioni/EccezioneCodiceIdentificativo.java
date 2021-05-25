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
public class EccezioneCodiceIdentificativo extends Exception 
{
    public EccezioneCodiceIdentificativo() 
    {
        
    }
    
    public String toString()
    {
        String s="";
        
        s="Non e' presente nessuna visita con questo codice identificativo!";
        
        return s;
    }
}