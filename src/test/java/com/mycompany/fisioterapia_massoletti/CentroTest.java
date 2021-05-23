/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fisioterapia_massoletti;

import eccezioni.*;
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
     */
    @Test
    public void testGetNVisitePresenti() 
    {
         
    }
    
    /**
     * Test of registraPrenotazione method, of class Centro.
     */
    @Test
    public void testRegistraPrenotazione()  
    {
        //Test 2.
        //Test 3.
    }
    
    /*@Test(expected=EccezionePosizioneNonValida.class)
    public void testCentroPieno() throws EccezionePosizioneNonValida
    {
        //Test 4.
    }*/

    /**
     * Test of visualizzaVisite method, of class Centro.
     */
    @Test
    public void testVisualizzaVisite() throws EccezionePosizioneNonValida, EccezioneNessunaVisita 
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

    @Test(expected=EccezioneNessunaVisita.class)
    public void testNessunaVisita() throws EccezioneNessunaVisita, EccezionePosizioneNonValida, EccezioneCodiceIdentificativo
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
    }

    /**
     * Test of numeroPrenotazioniPaziente method, of class Centro.
     */
    @Test
    public void testNumeroPrenotazioniPaziente() throws EccezionePosizioneNonValida, EccezioneNessunaVisita  
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
     */
    @Test
    public void testMostraPrenotazioni() throws EccezionePosizioneNonValida, EccezioneNessunaVisita 
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
     */
    @Test
    public void testRimuoviPrenotazione() throws Exception 
    {
        //Test 17.
        //Test 18.
    }
    
    @Test(expected=EccezioneCodiceIdentificativo.class)
    public void testCodiceSbagliato() throws EccezioneCodiceIdentificativo
    {
        //Test 16.
    }

    /**
     * Test of eseguiVisita method, of class Centro.
     */
    @Test
    public void testEseguiVisita() throws Exception 
    {
        
    }

    /**
     * Test of visualizzaPrenotazioniPerGiorno method, of class Centro.
     */
    @Test
    public void testVisualizzaPrenotazioniPerGiorno() throws Exception 
    {
        
    }

    /**
     * Test of visualizzaVisiteNonSvolteOrdineAlfabetico method, of class Centro.
     */
    @Test
    public void testVisualizzaVisiteNonSvolteOrdineAlfabetico() throws Exception 
    {
        
    }

    /**
     * Test of setCodiceIdentificativo method, of class Centro.
     */
    @Test
    public void testSetCodiceIdentificativo()
    {
        
    }

    /**
     * Test of esportaVisiteCSV method, of class Centro.
     */
    @Test
    public void testEsportaVisiteCSV() throws Exception
    {
        
    }

    /**
     * Test of salvaVisite method, of class Centro.
     */
    @Test
    public void testSalvaVisite() throws Exception 
    {
        
    }

    /**
     * Test of caricaVisite method, of class Centro.
     */
    @Test
    public void testCaricaVisite() throws Exception 
    {
        
    }

    /**
     * Test of toString method, of class Centro.
     */
    @Test
    public void testToString()
    {
        
    }
    
}
