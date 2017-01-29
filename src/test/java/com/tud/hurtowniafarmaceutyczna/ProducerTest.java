package com.tud.hurtowniafarmaceutyczna;

import com.tud.hurtowniafarmaceutyczna.controller.ProducentController;
import com.tud.hurtowniafarmaceutyczna.model.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by karol on 28.01.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProducerTest {

    @Autowired
    ProducentController producerController;

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
}
