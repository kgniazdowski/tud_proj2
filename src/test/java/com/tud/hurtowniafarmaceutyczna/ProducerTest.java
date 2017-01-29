package com.tud.hurtowniafarmaceutyczna;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tud.hurtowniafarmaceutyczna.controller.ProducerController;
import com.tud.hurtowniafarmaceutyczna.model.Producer;

/**
 * Created by karol on 28.01.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProducerTest {

    @Autowired
    ProducerController producerController;

    private String nazwaProducenta = "BAYER";
    private String miastoProducenta = "Gdynia";
    private String ulicaProducenta = "Borewicza";
    private String kodPocztowyProducenta = "80-428";
    private int nrProducenta = 12;

    @Test
    public void CheckAddingProducer()
    {
        Producer producer = new Producer(nazwaProducenta, miastoProducenta, ulicaProducenta, kodPocztowyProducenta, nrProducenta);
        producerController.AddProducer(producer);

        List<Producer> producentList = producerController.GetAllProducers();
        Producer insertedProducent = producentList.get(0);
        assertEquals(nazwaProducenta, insertedProducent.getNazwa());
    }
    
    @Test
    public void CheckGettingAllProducers()
    {
    List<Producer> producentList = producerController.GetAllProducers();
    assertEquals(0, producentList.size());
    Producer producent = new Producer(nazwaProducenta, miastoProducenta, ulicaProducenta, kodPocztowyProducenta, nrProducenta);
    producerController.AddProducer(producent);
    producentList = producerController.GetAllProducers();
    assertEquals(1, producentList.size());
    producent = new Producer(nazwaProducenta + "NEW", miastoProducenta, ulicaProducenta, kodPocztowyProducenta, nrProducenta);
    producerController.AddProducer(producent);
    producentList = producerController.GetAllProducers();
    assertEquals(2, producentList.size());
    }
    
    @Test
    public void CheckDeletingProducer()
    {
    Producer producent1 = new Producer(nazwaProducenta, miastoProducenta, ulicaProducenta, kodPocztowyProducenta, nrProducenta);
    producerController.AddProducer(producent1);
    Producer producent2 = new Producer(nazwaProducenta + "NEW", miastoProducenta, ulicaProducenta, kodPocztowyProducenta, nrProducenta);
    producerController.AddProducer(producent2);
    producerController.DeleteProducer(producent1);
    List<Producer> producentList = producerController.GetAllProducers();
    assertEquals(1, producentList.size());
    assertEquals(nazwaProducenta + "NEW", producentList.get(0).getNazwa());
    }
    
    @Test
    public void CheckUpdatingProducer()
    {
    Producer producent = new Producer(nazwaProducenta, miastoProducenta, ulicaProducenta, kodPocztowyProducenta, nrProducenta);
    producerController.AddProducer(producent);
    producent.setNazwa(nazwaProducenta + "R");
    producent.setMiasto(miastoProducenta + "R");
    producent.setUlica(ulicaProducenta + "R");
    producent.setKodPocztowy(kodPocztowyProducenta + "R");
    producent.setNr(9);
    producerController.UpdateProducer(producent);
    List<Producer> producentList = producerController.GetAllProducers();
    assertEquals(1, producentList.size());
    assertEquals("BAYERR", producentList.get(0).getNazwa());
    assertEquals(miastoProducenta + "R", producentList.get(0).getMiasto());
    assertEquals(ulicaProducenta + "R", producentList.get(0).getUlica());
    assertEquals(kodPocztowyProducenta + "R", producentList.get(0).getKodPocztowy());
    producent.setNazwa(nazwaProducenta);
    assertEquals(9, producentList.get(0).getNr());
    producerController.UpdateProducer(producent);
    producentList = producerController.GetAllProducers();
    assertEquals("BAYER", producentList.get(0).getNazwa());
    }
}
