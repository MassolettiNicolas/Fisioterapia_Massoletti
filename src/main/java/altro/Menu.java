/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altro;

import java.util.*;

/**
 *
 * @author nicio
 */
public class Menu 
{
    //Attributi.
    private String [] elencoVoci;
    private int numeroVoci;
            
    //Costruttore.
    public Menu(String [] elencoVoci)
    {
        numeroVoci=elencoVoci.length;
        this.elencoVoci=new String[numeroVoci]; 
        for(int i=0;i<numeroVoci;i++)
        {
            this.elencoVoci[i]=elencoVoci[i];
        }
    }
    
    //Metodi.
    public void VisualizzaMenu()
    {
        System.out.println("MENU':");
        for(int i=0;i<numeroVoci;i++)
        {
            System.out.println(i+" --> "+elencoVoci[i]);
        }
    }
    
    public int sceltaMenu()
    {
        Scanner tastiera=new Scanner(System.in);
        String inputUtente;
        int sceltaUtente=0;
        boolean inputUtenteOK=true;
        
        do
        {
            VisualizzaMenu();
        
            System.out.println("SCELTA --> ");
            inputUtente=tastiera.nextLine();

            //Verifico che l'input sia numerico.
            inputUtenteOK=true;
            for(int i=0;i<inputUtente.length();i++)
            {
                if(inputUtente.charAt(i)>='0' && inputUtente.charAt(i)<='9')
                    i++;
                else
                {
                    inputUtenteOK=false;
                    break;
                }     
            } 

            //Verifico che il numero sia valido (compreso fra 0 e numeroVoci-1).
            if(inputUtenteOK)   //E' uguale a dire inputUtenteOK==true.
            {
                sceltaUtente=Integer.parseInt(inputUtente);

                if(sceltaUtente<0 || sceltaUtente>numeroVoci-1)
                    inputUtenteOK=false;
            }

            if(!inputUtenteOK)   //E' uguale a dire inputUtenteOK==false.
            {
                System.out.println("Il valore inserito non e' corretto. Premi invio ed inserisci nuovamente la tua scelta!");
                tastiera.nextLine();   //Serve per aspettare la pressione del tasto Invio senza far scomparire la scritta del sout.
            }
            
        }while(!inputUtenteOK);
        
        return sceltaUtente;
    }
}
