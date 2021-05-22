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
     * Test of visualizzaVisite method, of class Centro.
     */
    @Test
    public void testVisualizzaVisite() throws EccezionePosizioneNonValida 
    {
        c1.registraPrenotazione(v1);
        c1.registraPrenotazione(v2);
        c1.registraPrenotazione(v3);
    }

    @Test(expected=EccezioneNessunaVisita.class)
    public void testNessunaVisita()
    {
        
    }

    /**
     * Test of registraPrenotazione method, of class Centro.
     */
    @Test
    public void testRegistraPrenotazione() throws Exception 
    {
        
    }
    
    @Test(expected=EccezionePosizioneNonValida.class)
    public void testPosizione()
    {
        
    }

    /**
     * Test of numeroPrenotazioniPaziente method, of class Centro.
     */
    @Test
    public void testNumeroPrenotazioniPaziente() throws Exception 
    {
        
    }

    /**
     * Test of mostraPrenotazioni method, of class Centro.
     */
    @Test
    public void testMostraPrenotazioni() throws Exception 
    {
        
    }

    /**
     * Test of rimuoviPrenotazione method, of class Centro.
     */
    @Test
    public void testRimuoviPrenotazione() throws Exception 
    {
        
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
