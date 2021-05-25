/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

import eccezioni.*;
import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class CentroTest 
{
    Visita v1, v2, v3;
    Centro c1;
    
    /**
     * @Before --> il metodo inizializzazione viene sempre eseguito prima grazie a questo tag.
     */
    @Before
    public void inizializzazione()
    {
       c1=new Centro();
       v1=new Visita(1, "Massoletti", "Nicolas", "veube", "massaggio", "Bonsi", "Giuseppe", 2021, 4, 5, 16, 30);
       v2=new Visita(2, "Giorgi", "Luca", "ewuib", "massaggio", "Giorgi", "Matteo", 2021, 6, 13, 15, 00);
       v3=new Visita(3, "Massoletti", "Nicolas", "eregr", "controllo", "Bonsi", "Giuseppe", 2021, 9, 25, 17, 15);
    }
    
    /**
     * Test of getNumMaxVisite method, of class Centro.
     */
    @Test
    public void testGetNumMaxVisite() 
    {
        //Test 1.
        int atteso, attuale;
        
        atteso=100;
        attuale=c1.getNumMaxVisite();
        
        assertEquals("Numero massimo di visite:", atteso, attuale);
    }

    /**
     * Test of getNVisitePresenti method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test
    public void testGetNVisitePresenti() throws Exception
    {
        //Test 38.
        int atteso, attuale;
        atteso=0;
        attuale=c1.getNVisitePresenti();
        assertEquals("Nessuna visita presente:", atteso, attuale);
        
        //Test 39.
        c1.registraPrenotazione(v1);
        int atteso1, attuale1;
        atteso1=1;
        attuale1=c1.getNVisitePresenti();
        assertEquals("1 Visita presente:", atteso1, attuale1);
        
        //Test 40.
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        int atteso2, attuale2;
        atteso2=3;
        attuale2=c1.getNVisitePresenti();
        assertEquals("3 visite presenti:", atteso2, attuale2);
    }
    
    /**
     * Test of registraPrenotazione method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test
    public void testRegistraPrenotazione() throws Exception  
    {
        //Test 2.
        c1.registraPrenotazione(v1); 
        
        //Test 3.
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
    }
    
    /**
     * Test of EccezionePosizioneNonValida exception, of class EccezionePosizioneNonValida.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test(expected=EccezionePosizioneNonValida.class)
    public void testCentroPieno() throws Exception
    {
        //Test 4.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v1);
        //100 visite registrate.
        c1.registraPrenotazione(v2);
    }

    /**
     * Test of visualizzaVisite method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test
    public void testVisualizzaVisite() throws Exception 
    {
        //Test 6.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        Visita[] atteso=new Visita[3];
        Visita[] attuale;
        atteso[0]=v1;
        atteso[1]=v2;
        atteso[2]=v3;
        attuale=c1.visualizzaVisite();
        assertArrayEquals("Visualizzazione di un centro con 3 visite:", atteso, attuale);
    }

    /**
     * Test of EccezioneNessunaVisita exception, of class EccezioneNessunaVisita.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test(expected=EccezioneNessunaVisita.class)
    public void testNessunaVisita() throws Exception
    {
        //Test 5.
        Visita[] atteso={null};
        Visita[] attuale;
        attuale=c1.visualizzaVisite();
        assertArrayEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro vuoto:", atteso, attuale);
        
        //Test 7.
        int atteso1, attuale1;
        atteso1=0;
        attuale1=c1.numeroPrenotazioniPaziente("Massoletti", "Nicolas");
        assertEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro vuoto:", atteso1, attuale1);
        
        //Test 8.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        int atteso2, attuale2;
        atteso2=0;
        attuale2=c1.numeroPrenotazioniPaziente("Maggioni", "Davide");
        assertEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro senza visite per il paziente specificato:", atteso2, attuale2);
        
        //Test 11.
        c1.rimuoviPrenotazione(1);
        c1.rimuoviPrenotazione(2);
        c1.rimuoviPrenotazione(3);
        Visita[] atteso3={null};
        Visita[] attuale3;
        attuale3=c1.mostraPrenotazioni("Massoletti", "Nicolas", c1.numeroPrenotazioniPaziente("Massoletti", "Nicolas"));
        assertArrayEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro vuoto:", atteso3, attuale3);
        
        //Test 12.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        Visita[] atteso4={null};
        Visita[] attuale4;
        attuale4=c1.mostraPrenotazioni("Maggioni", "Davide", c1.numeroPrenotazioniPaziente("Maggioni", "Davide"));
        assertArrayEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro senza visite per il paziente specificato:", atteso4, attuale4);
        
        //Test 15.
        c1.rimuoviPrenotazione(1);
        c1.rimuoviPrenotazione(2);
        c1.rimuoviPrenotazione(3);
        int atteso10, attuale10;
        atteso10=0;
        attuale10=c1.rimuoviPrenotazione(1);
        assertEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro vuoto:", atteso10, attuale10);
        
        //Test 19.       
        String atteso5, attuale5;
        atteso5="";
        attuale5=c1.eseguiVisita(1, "Nicolas", "Massoletti", 2021, 4, 5, 16, 30);
        assertEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro vuoto:", atteso5, attuale5);
        
        //Test 23.
        Visita[] atteso6={null};
        Visita[] attuale6;
        attuale6=c1.visualizzaPrenotazioniPerGiorno(2021, 1, 2);
        assertArrayEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro vuoto:", atteso6, attuale6);
        
        //Test 24.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
        Visita[] atteso7={null};
        Visita[] attuale7;
        attuale7=c1.visualizzaPrenotazioniPerGiorno(2020, 4, 5);
        assertArrayEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro con 3 visite, ma nessuna corrispondente alla data inserita:", atteso7, attuale7);
        
        //Test 27.
        c1.rimuoviPrenotazione(1);
        c1.rimuoviPrenotazione(2);
        c1.rimuoviPrenotazione(3);
        Visita[] atteso8={null};
        Visita[] attuale8;
        attuale8=c1.visualizzaVisiteNonSvolteOrdineAlfabetico();
        assertArrayEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con il centro vuoto:", atteso8, attuale8);
        
        //Test 28.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        c1.eseguiVisita(1, "Nicolas", "Massoletti", 2021, 4, 5, 16, 30);
        c1.eseguiVisita(2, "Luca", "Giorgi", 2021, 6, 13, 15, 00);
        c1.eseguiVisita(3, "Nicolas", "Massoletti", 2021, 9, 25, 17, 15);
        Visita[] atteso9={null};
        Visita[] attuale9;
        attuale9=c1.visualizzaVisiteNonSvolteOrdineAlfabetico();
        assertArrayEquals("Sollevazione dell'eccezione EccezioneNessunaVisita con tutte le visite gia' eseguite:", atteso9, attuale9);
    }

    /**
     * Test of numeroPrenotazioniPaziente method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni. 
     */
    @Test
    public void testNumeroPrenotazioniPaziente() throws Exception  
    {
        //Test 9.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        int atteso, attuale;
        atteso=1;
        attuale=c1.numeroPrenotazioniPaziente("Massoletti", "Nicolas");
        assertEquals("Numero di prenotazioni per il paziente specifico:", atteso, attuale);
        
        //Test 10.
        //Le registrazioni aggiunte prima rimangono.
        c1.registraPrenotazione(v3);
        int atteso1, attuale1;
        atteso1=2;
        attuale1=c1.numeroPrenotazioniPaziente("Massoletti", "Nicolas");
        assertEquals("Numero di prenotazioni per il paziente specifico:", atteso1, attuale1);
    }

    /**
     * Test of mostraPrenotazioni method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni. 
     */
    @Test
    public void testMostraPrenotazioni() throws Exception 
    {
        //Test 13.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        Visita[] atteso={null};
        Visita[] attuale;
        atteso[0]=v1;
        attuale=c1.mostraPrenotazioni("Massoletti", "Nicolas", c1.numeroPrenotazioniPaziente("Massoletti", "Nicolas"));
        assertArrayEquals("Array di prenotazioni per il paziente specifico:", atteso, attuale);
        
        //Test 14.
        //Le registrazioni aggiunte prima rimangono.
        c1.registraPrenotazione(v3);
        atteso=new Visita[2];
        atteso[0]=v1;
        atteso[1]=v3;
        attuale=c1.mostraPrenotazioni("Massoletti", "Nicolas", c1.numeroPrenotazioniPaziente("Massoletti", "Nicolas"));
        assertArrayEquals("Array di prenotazioni per il paziente specifico:", atteso, attuale);
    }

    /**
     * Test of rimuoviPrenotazione method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni. 
     */
    @Test
    public void testRimuoviPrenotazione() throws Exception 
    {
        //Test 17.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        int atteso, attuale;
        atteso=0;
        attuale=c1.rimuoviPrenotazione(3);
        assertEquals("Eliminazione di una delle due visite del paziente:", atteso, attuale);
        
        //Test 18.
        int atteso1, attuale1;
        atteso1=0;
        attuale1=c1.rimuoviPrenotazione(1);
        assertEquals("Eliminazione della visita del paziente:", atteso1, attuale1);
    }
    
    /**
     * Test of EccezioneCodiceIdentificativo exception, of class EccezioneCodiceIdentificativo.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test(expected=EccezioneCodiceIdentificativo.class)
    public void testCodiceSbagliato() throws Exception
    {
        //Test 16.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        int atteso, attuale;
        atteso=0;
        attuale=c1.rimuoviPrenotazione(4);
        assertEquals("Sollevazione dell'eccezione EccezioneCodiceIdentificativo con il centro con 3 visite, ma nessuna con quel codice:", atteso, attuale);
    }

    /**
     * Test of eseguiVisita method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni. 
     */
    @Test
    public void testEseguiVisita() throws Exception 
    {
        //Test 22.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
        String atteso, attuale;
        attuale=c1.eseguiVisita(1, "Nicolas", "Massoletti", 2021, 4, 5, 16, 30);
        atteso=v1.toString();
        assertEquals("Stringa della visita eseguita:", atteso, attuale);
    }
    
    /**
     * Test of EccezioneVisitaSvolta exception, of class EccezioneVisitaSvolta.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test(expected=EccezioneVisitaSvolta.class)
    public void testVisiteEseguite() throws Exception
    {
        //Test 20.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        c1.eseguiVisita(1, "Nicolas", "Massoletti", 2021, 4, 5, 16, 30);
        c1.eseguiVisita(2, "Luca", "Giorgi", 2021, 6, 13, 15, 00);
        c1.eseguiVisita(3, "Nicolas", "Massoletti", 2021, 9, 25, 17, 15);
        String atteso, attuale;
        atteso="";
        attuale=c1.eseguiVisita(1, "Nicolas", "Massoletti", 2021, 4, 5, 16, 30);
        assertEquals("Sollevazione dell'eccezione EccezioneVisitaSvolta con il centro con tutte le visite gia' eseguite:", atteso, attuale);
        
        //Test 21.
        v1.setVisitaSvolta("N");
        v2.setVisitaSvolta("N");
        v3.setVisitaSvolta("N"); 
        String atteso1, attuale1;
        atteso1="";
        attuale1=c1.eseguiVisita(6, "Ducoli", "Fau", 2020, 10, 20, 10, 40);
        assertEquals("Sollevazione dell'eccezione EccezioneVisitaSvolta con dati che non corrispondono a nessuna visita:",atteso1, attuale1);
    }

    /**
     * Test of visualizzaPrenotazioniPerGiorno method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni. 
     */
    @Test
    public void testVisualizzaPrenotazioniPerGiorno() throws Exception 
    {
        //Test 25.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        Visita[] atteso=new Visita[1];
        Visita[] attuale;
        atteso[0]=v1;
        attuale=c1.visualizzaPrenotazioniPerGiorno(2021, 4, 5);
        assertArrayEquals("Array con la visita corrispondente alla data:", atteso, attuale);
        
        //Test 26.
        v2.setAppuntamento(2021, 4, 5, 16, 30);
        Visita[] atteso1=new Visita[2];
        Visita[] attuale1;
        atteso1[0]=v1;
        atteso1[1]=v2;
        attuale1=c1.visualizzaPrenotazioniPerGiorno(2021, 4, 5);
        assertArrayEquals("Array con le visite corrispondenti alla data:", atteso1, attuale1);
    }

    /**
     * Test of visualizzaVisiteNonSvolteOrdineAlfabetico method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test
    public void testVisualizzaVisiteNonSvolteOrdineAlfabetico() throws Exception 
    {
        //Test 29.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
        c1.eseguiVisita(1, "Nicolas", "Massoletti", 2021, 4, 5, 16, 30);
        c1.eseguiVisita(2, "Luca", "Giorgi", 2021, 6, 13, 15, 00);
        Visita[] atteso=new Visita[1];
        atteso[0]=v3;
        Visita[] attuale;
        attuale=c1.visualizzaVisiteNonSvolteOrdineAlfabetico();
        assertArrayEquals("Array con la visita non svolta:", atteso, attuale);
        
        //Test 30.
        v2.setVisitaSvolta("N");
        Visita[] atteso1=new Visita[2];
        atteso1[0]=v2;
        atteso1[1]=v3;
        Visita[] attuale1;
        attuale1=c1.visualizzaVisiteNonSvolteOrdineAlfabetico();
        assertArrayEquals("Array con le visite non svolte in ordine alfabetico:", atteso1, attuale1);
    }

    /**
     * Test of esportaVisiteCSV method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test
    public void testEsportaVisiteCSV() throws Exception
    {
        //Test 31.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2); 
        c1.registraPrenotazione(v3); 
        c1.esportaVisiteCSV("centroTest.txt"); 
    }

    /**
     * Test of salvaVisite method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test
    public void testSalvaVisite() throws Exception 
    {
        //Test 32.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2); 
        c1.registraPrenotazione(v3);
        c1.salvaVisite("centroTest1.bin"); 
    }

    /**
     * Test of caricaVisite method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test
    public void testCaricaVisite() throws Exception 
    {
        //Test 34.  
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2); 
        c1.registraPrenotazione(v3); 
        c1.salvaVisite("centroTest1.bin"); 
        Centro atteso, attuale;
        atteso=c1;
        attuale=c1.caricaVisite("centroTest1.bin");
        assertEquals("Carica i dati dal file corretto:", atteso, attuale);
    }
    
    /**
     * Test of FileNotFoundException exception, of class FileNotFoundException.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test(expected=FileNotFoundException.class)
    public void testCaricaDaFileInesistente() throws Exception
    {
        //Test 33.
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2); 
        c1.registraPrenotazione(v3); 
        c1.salvaVisite("centro.bin"); 
        c1.rimuoviPrenotazione(1);
        c1.rimuoviPrenotazione(2);
        c1.rimuoviPrenotazione(3);
        Centro atteso, attuale;
        Centro c2=new Centro();
        atteso=c2;
        attuale=c1.caricaVisite("fileInesistente.bin");
        assertEquals("Carica i dati da un file inesistente:", atteso, attuale);
    }

    /**
     * Test of toString method, of class Centro.
     * @throws Exception contiene tutte le possibili eccezioni.
     */
    @Test
    public void testToString() throws Exception
    {
        //Test 35.
        String atteso, attuale;
        atteso="";
        attuale=c1.toString();
        assertEquals("Visualizzo stringhe vuote:", atteso, attuale);
        
        //Test 36.
        c1.registraPrenotazione(v1);
        String atteso1, attuale1;
        atteso1=v1.toString()+"\n";
        attuale1=c1.toString();
        assertEquals("Visualizzo la visita presente:", atteso1, attuale1);
        
        //Test 37.
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3); 
        String atteso2, attuale2;
        atteso2=v1.toString()+"\n"+v2.toString()+"\n"+v3.toString()+"\n";
        attuale2=c1.toString();
        assertEquals("Visualizzo tutte le visite presenti:", atteso2, attuale2);
    }   
}
