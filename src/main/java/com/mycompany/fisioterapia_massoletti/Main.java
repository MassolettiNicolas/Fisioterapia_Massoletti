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
        int prossimoCodiceIdentificativoAutomatico=1;
        String[] vociMenu=new String[9];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        Centro c1=new Centro();  
        int esitoOperazione;
        int codiceID, anno, mese, giorno, ora, minuto;
        String nome, cognome, nomeFisio, cognomeFisio, codiceFiscale, descrizioneVisita;
        int codice=0;   //Serve per assegnare i codici quando vengono caricati i dati da file.
        String nomeFileCSV="centro.txt";
        String nomeFileBinario="centro.bin";
        
        vociMenu[0]="Esci";
        vociMenu[1]="Registra prenotazione";
        vociMenu[2]="Elimina prenotazione";
        vociMenu[3]="Esegui una visita";
        vociMenu[4]="Visualizza tutte le prenotazioni presenti";
        vociMenu[5]="Visualizza prenotazioni di un giorno";
        vociMenu[6]="Visualizza visite non svolte in ordine alfabetico";
        vociMenu[7]="Esporta i dati su file CSV";
        vociMenu[8]="Salva dati";
        
        //Deserializzazione.
        //Se modifico il codice è normale che non carichi i dati la prima volta, ma devo prima salvare 
        //e poi li caricherà giusti.
        try
        {
            c1=c1.caricaVisite(nomeFileBinario);
            
            for(int i=0;i<c1.getNVisitePresenti();i++)
            {
                codice++;
                c1.setCodiceIdentificativo(i,codice);
            }
            
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
                        System.out.println("Cognome --> ");                  
                        cognome=tastiera.nextLine();
                        System.out.println("Nome --> ");                  
                        nome=tastiera.nextLine();
                        System.out.println("Codice fiscale --> ");                  
                        codiceFiscale=tastiera.nextLine();
                        System.out.println("Descrizione visita (massaggio, controllo ecc...) --> ");                  
                        descrizioneVisita=tastiera.nextLine();
                        System.out.println("Cognome fisioterapista --> ");                  
                        cognomeFisio=tastiera.nextLine(); 
                        System.out.println("Nome fisioterapista --> ");                  
                        nomeFisio=tastiera.nextLine(); 
                        //LocalDateTime appuntamento, inserimento dati:
                        System.out.println("Anno della visita --> ");
                        anno=tastiera.nextInt();
                        System.out.println("Mese della visita --> ");
                        mese=tastiera.nextInt();
                        System.out.println("Giorno della visita --> ");
                        giorno=tastiera.nextInt();
                        System.out.println("Ora della visita --> ");
                        ora=tastiera.nextInt();
                        System.out.println("Minuto della visita --> ");
                        minuto=tastiera.nextInt();
                        Visita visita=new Visita(prossimoCodiceIdentificativoAutomatico, cognome, nome, codiceFiscale, descrizioneVisita, cognomeFisio, nomeFisio, anno, mese, giorno, ora, minuto);
                        System.out.println("Il parametro visitaSvolta viene impostato automaticamente su N!");
                        
                        try
                        {
                            c1.registraPrenotazione(visita); 
                            prossimoCodiceIdentificativoAutomatico++;   
                            System.out.println("Ok, inserimento eseguito correttamente!");
                        }
                        catch(EccezionePosizioneNonValida e1)
                        {
                            System.out.println(e1.toString());
                        }
                        
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
                        cognome=tastiera.nextLine();
                        System.out.println("Nome --> ");                  
                        nome=tastiera.nextLine(); 
                        
                        try
                        {
                            lunghezzaArray=c1.numeroPrenotazioniPaziente(cognome, nome);
                            arrayVisite=c1.mostraPrenotazioni(cognome, nome, lunghezzaArray);
                            for(int i=0;i<arrayVisite.length;i++)
                            {
                                if(arrayVisite[i]!=null)
                                   System.out.println(arrayVisite[i]); 
                            }                               
                            System.out.println("Codice della visita da eliminare --> ");                  
                            codiceID=tastiera.nextInt();
                            
                            try
                            {
                                esitoOperazione=c1.rimuoviPrenotazione(codiceID);
                                System.out.println("Eliminazione avvenuta correttamente!");
                            }
                            catch(EccezioneCodiceIdentificativo e1)
                            {
                                System.out.println(e1.toString());
                            }
                            catch(EccezioneNessunaVisita e1)
                            {
                                System.out.println(e1.toString());
                            }
                        }
                        catch(EccezioneNessunaVisita e1)
                        {
                            System.out.println(e1.toString());
                        }
                        
                        System.out.println("Premi un pulsante per continuare.");
                        tastiera.nextLine();
                        
                        break;
                    }
                    case 3:
                    {
                        String visitaScelta="";
                        System.out.println("ESEGUI UNA VISITA:");
                        System.out.println("Cognome --> ");                  
                        cognome=tastiera.nextLine(); 
                        System.out.println("Nome --> ");                  
                        nome=tastiera.nextLine(); 
                        //LocalDateTime appuntamento, inserimento dati:
                        System.out.println("Anno della visita --> ");
                        anno=tastiera.nextInt();
                        System.out.println("Mese della visita --> ");
                        mese=tastiera.nextInt();
                        System.out.println("Giorno della visita --> ");
                        giorno=tastiera.nextInt();
                        System.out.println("Ora della visita --> ");
                        ora=tastiera.nextInt();
                        System.out.println("Minuto della visita --> ");
                        minuto=tastiera.nextInt();
                        System.out.println("Codice identificativo (nel caso fossero presenti visite con parametri uguali) --> ");                  
                        codiceID=tastiera.nextInt();
                        
                        try
                        {
                            visitaScelta=c1.eseguiVisita(codiceID, nome, cognome, anno, mese, giorno, ora, minuto);
                            System.out.println("VISITA ESEGUITA --> ");
                            System.out.println(visitaScelta);
                        }
                        catch(EccezioneVisitaSvolta e1)
                        {
                            System.out.println(e1.toString());
                        }
                        catch(EccezioneNessunaVisita e1)
                        {
                            System.out.println(e1.toString());
                        }
                                
                        System.out.println("Premi un pulsante per continuare.");
                        tastiera.nextLine();
                        
                        break;
                    }
                    case 4:
                    {
                        Visita[] arrayVisite;
                        System.out.println("VISUALIZZA LE VISITE PRESENTI:");
                        
                        try
                        {
                           arrayVisite=c1.visualizzaVisite(); 
                           for(int i=0;i<arrayVisite.length;i++)
                                System.out.println(arrayVisite[i]);
                        }
                        catch(EccezioneNessunaVisita e1)
                        {
                            System.out.println(e1.toString());
                        }
                        
                        System.out.println("Premi un pulsante per continuare.");
                        tastiera.nextLine();
                        
                        break;
                    }
                    case 5:
                    {
                        Visita[] arrayVisitePerGiorno;
                        System.out.println("VISUALIZZA LE VISITE PER UN GIORNO:");
                        System.out.println("Anno della visita --> ");
                        anno=tastiera.nextInt();
                        System.out.println("Mese della visita --> ");
                        mese=tastiera.nextInt();
                        System.out.println("Giorno della visita --> ");
                        giorno=tastiera.nextInt();
                        
                        try
                        {
                            arrayVisitePerGiorno=c1.visualizzaPrenotazioniPerGiorno(anno, mese, giorno);
                            for(int i=0;i<arrayVisitePerGiorno.length;i++)
                                System.out.println(arrayVisitePerGiorno[i]); 
                        }
                        catch(EccezioneNessunaVisita e1)
                        {
                            System.out.println(e1.toString());
                        }   
                        
                        System.out.println("Premi un pulsante per continuare.");
                        tastiera.nextLine();
                        
                        break;
                    }
                    case 6:
                    {
                        Visita[] arrayVisiteNonSvolte;
                        System.out.println("VISUALIZZA VISITE NON SVOLTE IN ORDINE ALFABETICO:");  
                        
                        try
                        {
                            arrayVisiteNonSvolte=c1.visualizzaVisiteNonSvolteOrdineAlfabetico();
                            for(int i=0;i<arrayVisiteNonSvolte.length;i++)
                                System.out.println(arrayVisiteNonSvolte[i]);
                        }
                        catch(EccezioneNessunaVisita e1)
                        {
                            System.out.println(e1.toString());
                        }
                        catch(EccezioneVisitaSvolta e1)
                        {
                            System.out.println("Le visite presenti sono state svolte tutte!");
                        }
                        
                        System.out.println("Premi un pulsante per continuare.");
                        tastiera.nextLine();
                        
                        break;
                    }
                    case 7:
                    {
                        System.out.println("ESPORTA IN CSV:");
                        try
                        {
                            c1.esportaVisiteCSV(nomeFileCSV); 
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
                    case 8:
                    {
                        System.out.println("SALVA DATI:");
                        //Serializzazione.
                        try 
                        {
                            c1.salvaVisite(nomeFileBinario);
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