/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

import altro.*;
import eccezioni.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Nicolas
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[8];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Centro c1=new Centro();
        Visita visita=new Visita();   //cambiare perchè usa la data sbagliata.
        int esitoOperazione;
        String nomeFileCSV="centro.txt";
        String nomeFileBinario="centro.bin";
        
        vociMenu[0]="Esci";
        vociMenu[1]="Registra prenotazione";
        vociMenu[2]="Elimina prenotazione";
        vociMenu[3]="Esegui una visita";
        vociMenu[4]="Visualizza prenotazioni di un giorno";
        vociMenu[5]="Visualizza visite non svolte in ordine alfabetico";
        vociMenu[6]="Esporta i dati su file CSV";
        vociMenu[7]="Salva dati";
        
        //Deserializzazione.
        try
        {
            c1=c1.caricaCentro(nomeFileBinario);
            System.out.println("Dati caricati correttamente!");
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Impossibile accedere al file, i dati non sono stati caricati!");
        }
        catch(FileException ex)
        {
            System.out.println("Errore di lettura, i dati non sono stati caricati!");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file!");
        }
        
        Menu menu=new Menu(vociMenu);   //Istanzio il menù.
        
        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();
                switch(sceltaUtente)
                {
                    case 0:
                    {
                        System.out.println("L'applicazione verra' terminata!");
                        
                        break;
                    }
                    case 1:
                    {
                        System.out.println("REGISTRA VISITA:");
                        visita=new Visita();
                        System.out.println("Codice identificativo --> ");                  
                        visita.setCodiceIdentificativo(tastiera.nextInt()); 
                        tastiera.nextLine();
                        System.out.println("Cognome --> ");                  
                        visita.setCognome(tastiera.nextLine()); 
                        System.out.println("Nome --> ");                  
                        visita.setNome(tastiera.nextLine()); 
                        System.out.println("Codice fiscale --> ");                  
                        visita.setCFPaziente(tastiera.nextLine());
                        System.out.println("Descrizione visita (massaggio, controllo ecc...) --> ");                  
                        visita.setDescrizioneVisita(tastiera.nextLine());
                        System.out.println("Cognome fisioterapista --> ");                  
                        visita.setCognomeFisioterapista(tastiera.nextLine()); 
                        System.out.println("Nome fisioterapista --> ");                  
                        visita.setNomeFisioterapista(tastiera.nextLine()); 
                        //LocalDateTime appuntamento, inserimento dati:
                        System.out.println("Anno della visita --> ");
                        int anno=tastiera.nextInt();
                        System.out.println("Mese della visita --> ");
                        int mese=tastiera.nextInt();
                        System.out.println("Giorno della visita --> ");
                        int giorno=tastiera.nextInt();
                        System.out.println("Ora della visita --> ");
                        int ora=tastiera.nextInt();
                        System.out.println("Minuto della visita --> ");
                        int minuto=tastiera.nextInt();
                        visita.setAppuntamento(anno, mese, giorno, ora, minuto); 
                        System.out.println("Il parametro visitaSvolta viene impostato automaticamente su N!");
                        
                        esitoOperazione=c1.registraPrenotazione(visita); 
                        if(esitoOperazione==0)
                            System.out.println("Ok, inserimento eseguito correttamente!");
                        else
                            System.out.println("Numero massimo di visite raggiunto!");
                        
                        System.out.println("Premi un pulsante per continuare.");
                        tastiera.nextLine();
                        
                        break;
                    }
                    case 2:
                    {
                        Visita[] arrayVisite;
                        int lunghezzaArray;
                        System.out.println("ELIMINA VISITA:");
                        System.out.println("Cognome --> ");                  
                        String cognome=tastiera.nextLine();
                        System.out.println("Nome --> ");                  
                        String nome=tastiera.nextLine(); 
                        lunghezzaArray=c1.numeroPrenotazioniPaziente(cognome, nome);
                        arrayVisite=c1.mostraPrenotazioni(cognome, nome);
                        for(int i=0;i<arrayVisite.length;i++)
                            System.out.println(arrayVisite[i]);
                        System.out.println("Codice della visita da eliminare --> ");                  
                        int codiceID=tastiera.nextInt();
                        esitoOperazione=c1.rimuoviPrenotazione(codiceID, arrayVisite);
                        if(esitoOperazione==0)
                            System.out.println("Eliminazione avvenuta correttamente!");
                        else
                            System.out.println("Eliminazione non avvenuta!");
                        
                        break;
                    }
                    case 3:
                    {
                        String visitaScelta="";
                        int codiceID=-1;
                        String nome="";
                        String cognome="";
                        System.out.println("ESEGUI UNA VISITA:");
                        System.out.println("Cognome --> ");                  
                        visita.setCognome(tastiera.nextLine()); 
                        System.out.println("Nome --> ");                  
                        visita.setNome(tastiera.nextLine()); 
                        //LocalDateTime appuntamento, inserimento dati:
                        System.out.println("Anno della visita --> ");
                        int anno=tastiera.nextInt();
                        System.out.println("Mese della visita --> ");
                        int mese=tastiera.nextInt();
                        System.out.println("Giorno della visita --> ");
                        int giorno=tastiera.nextInt();
                        System.out.println("Ora della visita --> ");
                        int ora=tastiera.nextInt();
                        System.out.println("Minuto della visita --> ");
                        int minuto=tastiera.nextInt();
                        visita.setAppuntamento(anno, mese, giorno, ora, minuto);
                        System.out.println("Codice identificativo (nel caso fossero presenti visite con parametri uguali) --> ");                  
                        visita.setCodiceIdentificativo(tastiera.nextInt()); 
                        System.out.println("PRIMA DELL'ESECUZIONE --> ");
                        System.out.println(visita.toString());
                        visitaScelta=c1.eseguiVisita(codiceID, nome, cognome, anno, mese, giorno, ora, minuto);
                        System.out.println("DOPO L'ESECUZIONE --> ");
                        System.out.println(visitaScelta);
                        
                        break;
                    }
                    case 4:
                    {
                        Visita[] arrayVisitePerGiorno;
                        System.out.println("VISUALIZZA LE VISITE PER UN GIORNO:");
                        System.out.println("Anno della visita --> ");
                        int anno=tastiera.nextInt();
                        System.out.println("Mese della visita --> ");
                        int mese=tastiera.nextInt();
                        System.out.println("Giorno della visita --> ");
                        int giorno=tastiera.nextInt();
                        arrayVisitePerGiorno=c1.visualizzaPrenotazioniPerGiorno(anno, mese, giorno);
                        if(arrayVisitePerGiorno==null)
                            System.out.println("Nessuna visita per questo giorno!");
                        else
                        {
                           for(int i=0;i<arrayVisitePerGiorno.length;i++)
                            System.out.println(arrayVisitePerGiorno[i]); 
                        }     
                        
                        break;
                    }
                    case 5:
                    {
                        Visita[] arrayVisiteNonSvolte;
                        System.out.println("VISUALIZZA NON SVOLTE IN ORDINE ALFABETICO:");                       
                        arrayVisiteNonSvolte=c1.visualizzaVisiteNonSvolteOrdineAlfabetico();
                        if(arrayVisiteNonSvolte==null)
                            System.out.println("Nessuna visita per questo giorno!");
                        else
                        {
                           for(int i=0;i<arrayVisiteNonSvolte.length;i++)
                            System.out.println(arrayVisiteNonSvolte[i]); 
                        }  
                        
                        break;
                    }
                    case 6:
                    {
                        System.out.println("ESPORTA IN CSV:");
                        try
                        {
                            c1.esportaLibri(nomeFileCSV); 
                            System.out.println("Esportazione avvenuta correttamente su file CSV!");
                        }
                        catch(IOException e1)
                        {
                            System.out.println("Impossibile accedere al file, i libri non sono stati salvati!");
                        }
                        catch(FileException e2)   
                        {
                            System.out.println(e2.toString());
                        }
                        
                        break;
                    }
                    case 7:
                    {
                        System.out.println("SALVA DATI:");
                        //Serializzazione.
                        try 
                        {
                            c1.salvaCentro(nomeFileBinario);
                            System.out.println("Dati salvati correttamente!");
                        } 
                        catch (IOException ex) 
                        {
                            System.out.println("Impossibile accedere al file, i dati non sono stati salvati!");
                        }
                        
                        break;
                    }
                }
            }
            catch(InputMismatchException | NumberFormatException e1)   //Controllo dell'input.
            {
               tastiera.nextLine();
               System.out.println("Input non corretto!");
            }
            
        }while(sceltaUtente!=0);
        
        /*
        Visita v1=new Visita(1,"Massoletti","Nicolas","abcde","Esercizi Rinforzanti","Bonsi","Giuseppe",2021,5,12,15,15,"N");
        Visita v2=new Visita(v1);
        Visita v2=new Visita(2,"m","n","dfbdb","ex","bonsi","giuse",2021,4,13,4,6,"S");
        Visita v3=new Visita();
        Visita v4=new Visita(3,"massoletti","nicolas","dfbdb","ex","bonsi","giuse",2021,4,13,4,6,"S");
        Visita v5=new Visita(4,"Massoletti","Nicolas","dfbdb","ex","bonsi","giuse",2021,4,13,4,6,"S");
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
        
        Centro c1=new Centro();
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
        System.out.println(c1.getNVisitePresenti());
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
        c1.registraPrenotazione(v4);
        c1.registraPrenotazione(v5);
        Visita[] arrayVisite=new Visita[c1.getNVisitePresenti()];
        c1.mostraPrenotazioni("Massoletti","Nicolas",arrayVisite);
        Scanner tastiera=new Scanner(System.in);
        int codice,easy=0;
        System.out.println("ins:");
        codice=tastiera.nextInt();
        easy=c1.rimuoviPrenotazione(codice,arrayVisite);
        if(easy==0)
            System.out.println("easy");
        else
            System.out.println("manai");
        for(int i=0;i<arrayVisite.length;i++)
        {
            if(arrayVisite[i]!=null)
                System.out.println(arrayVisite[i].toString());
        }      
        
        c1.visualizzaPrenotazioniPerGiorno(2021,4,13);
        String nomeFileCSV="visiteCentro.txt";
        try
        {
            c1.esportaLibri(nomeFileCSV);
            System.out.println("Esportazione avvenuta correttamente su file CSV!");
        }
        catch(IOException e1)
        {
            System.out.println("Impossibile accedere al file, i libri non sono stati salvati!");
        }
        catch(FileException e2)
        {
            System.out.println(e2.toString());
        }
        String nomeFileBinario="centro.bin";
        
        //Deserializzazione.
        try
        {
            c1=c1.caricaCentro(nomeFileBinario);
            System.out.println("Dati caricati correttamente!");
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Impossibile accedere al file, i dati non sono stati caricati!");
        }
        catch(FileException ex)
        {
            System.out.println("Errore di lettura, i dati non sono stati caricati!");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file!");
        }
        
        //Serializzazione.
        try 
        {
            c1.salvaCentro(nomeFileBinario);
            System.out.println("Dati salvati correttamente!");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file, i dati non sono stati salvati!");
        }
        
        Visita[] elenco;
        int anno=2021, mese=4, giorno=13;
        
        elenco=c1.visualizzaPrenotazioniPerGiorno(anno, mese, giorno);
        if(elenco==null)
            System.out.println("Nessuna prenotazione per questo giorno!");
        
        for(int i=0;i<elenco.length;i++)
        {
            System.out.println(elenco[i]);
        }
        
        String visitaScelta="";
        visitaScelta=c1.eseguiVisita(3, "Massoletti", "Nicolas", 2021, 4, 13, 4, 6);
        System.out.println(visitaScelta);*/
    }
}
