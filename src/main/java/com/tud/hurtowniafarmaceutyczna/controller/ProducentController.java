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
public class ProducentController {
    @Autowired
    private SessionFactory sessionFactory;

    public void AddProducer(Producer producer)
    {
        sessionFactory.getCurrentSession().persist(producer);
    }

    public List<Producer> GetAllProducers()
    {
        return sessionFactory.getCurrentSession().getNamedQuery("Producer.getAllProducers").list();
    }
}
