package com.tud.hurtowniafarmaceutyczna.controller;

import com.tud.hurtowniafarmaceutyczna.model.Producer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karol on 28.01.2017.
 */
@Component
@Transactional
public class ProducerController {
    @Autowired
    private SessionFactory sessionFactory;

    public void AddProducer(Producer producer)
    {
        sessionFactory.getCurrentSession().persist(producer);
    }
    
    public void DeleteProducer(Producer producer)
    {
    	Producer producerToDelete = (Producer) sessionFactory.getCurrentSession().get(Producer.class, producer.getId());
    	sessionFactory.getCurrentSession().delete(producerToDelete);
    }
    
    public void UpdateProducer(Producer producer)
    {
    	sessionFactory.getCurrentSession().update(producer);
    }

    @SuppressWarnings("unchecked")
	public List<Producer> GetAllProducers()
    {
        return sessionFactory.getCurrentSession().getNamedQuery("Producer.getAllProducers").list();
    }
}
