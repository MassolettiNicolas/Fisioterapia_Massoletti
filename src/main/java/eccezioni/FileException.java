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
public class FileException extends Exception 
{
    //Attributi.
    private String motivoEccezione;
    
    //Costruttore.
    public FileException(String message) 
    {
        motivoEccezione=message;
    }  
    
    //Overrade.
    public String toString()
    {
        return motivoEccezione;
    }
}