/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;
import eccezioni.*;

import java.io.*;

/**
 *
 * @author Nicolas
 */
public class TextFile 
{
    //Attributi.
    private char mode;   //Indica se voglio scrivere o leggere dal file (R = read / W = write).
    private BufferedReader reader;
    private BufferedWriter writer;
    
    //Costruttore classico.
    public TextFile(String fileName, char mode) throws IOException
    {
        this.mode='R';
        
        if(mode=='w' || mode=='W')
            this.mode='W';
        
        if(mode=='W')
            writer=new BufferedWriter(new FileWriter(fileName)); 
        else
            reader=new BufferedReader(new FileReader(fileName)); 
    }
    
    //Costruttore con append.
    public TextFile(String fileName, char mode, boolean append) throws IOException
    {
        this.mode='R';
        
        if(mode=='w' || mode=='W')
            this.mode='W';
        
        if(mode=='W')
            writer=new BufferedWriter(new FileWriter(fileName,append)); 
        else
            reader=new BufferedReader(new FileReader(fileName)); 
    }
    
    //Metodo di scrittura sul file.
    public void toFile(String line) throws FileException, IOException
    {
        if(mode=='R')
            throw new FileException("Impossibile scrivere sul file. File aperto in lettura!");   //Istruzione che consente d'istanziare una nuova eccezione.
        
        writer.write(line); 
        writer.newLine();
    }
    
    //Metodo di lettura dal file.
    public String fromFile() throws FileException, IOException
    {
        String rigaLetta;
        
        if(mode=='W')
            throw new FileException("Impossibile leggere dal file. File aperto in scrittura!");   //Istruzione che consente d'istanziare una nuova eccezione.
        
        rigaLetta=reader.readLine();
        
        if(rigaLetta==null)
            throw new FileException("Fine del file!");   //Istruzione che consente d'istanziare una nuova eccezione.
        
        return rigaLetta;
    }
    
    //Metodo di chiusura del file.
    public void close() throws IOException
    {
        if(mode=='W')
            writer.close();
        else
            reader.close();
    }
}