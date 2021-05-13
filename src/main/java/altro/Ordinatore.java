/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altro;

import com.mycompany.fisioterapia_massoletti.*;

/**
 *
 * @author nicio
 */
public class Ordinatore 
{
    public static void scambia(Visita v[], int posizione1, int posizione2)
    {
        Visita c;
        
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    //Metodi.
    public static void scambia(int v[], int posizione1, int posizione2)
    {
        int c;
        
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static void scambia(String v[], int posizione1, int posizione2)
    {
        String c;
        
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    //Ordina un array di Visite in ordine alfabetico. 
    public static Visita[] selectionSortAlfabeticoAutoreTitolo(Visita[] a)
    {
        Visita[] ordinato=new Visita[a.length];
        
        //Creo un vettore di copia che sarà il vettore ordinato restituito.
        for(int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        
        //Applico l'algoritmo Selection Sort al vettore di copia.
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())<0) 
                    scambia(ordinato,i,j);
            }
        }
        
        return ordinato;
    }
    
    public static int[] selectionSortCrescente(int[] a)
    {
        int [] ordinato=new int[a.length];
        
        //Creo un vettore di copia che sarà il vettore ordinato restituito.
        for(int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        
        //Applico l'algoritmo Selection Sort al vettore di copia.
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]<ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        
        return ordinato;
    }
    
    public static int[] selectionSortDecrescente(int[] a)
    {
        int [] ordinato=new int[a.length];
        
        for(int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]>ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        
        return ordinato;
    }
    
    //Ordina un array di stringhe in ordine alfabetico.
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        //Creo un vettore di copia che sarà il vettore ordinato restituito.
        for(int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        
        //Applico l'algoritmo Selection Sort al vettore di copia.
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }
        
        return ordinato;
    }
    
    //Ordina un array di stringhe in ordine alfabetico inverso.
    public static String[] selectionSortDecrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        //Creo un vettore di copia che sarà il vettore ordinato restituito.
        for(int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        
        //Applico l'algoritmo Selection Sort al vettore di copia.
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])>0)
                    scambia(ordinato,i,j);
            }
        }
        
        return ordinato;
    }
}
