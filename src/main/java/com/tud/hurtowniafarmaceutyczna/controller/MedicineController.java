package com.tud.hurtowniafarmaceutyczna.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tud.hurtowniafarmaceutyczna.model.Medicine;

@Component
@Transactional
public class MedicineController {
    @Autowired
    private SessionFactory sessionFactory;
    
    public void AddMedicine(Medicine medicine)
    {
        sessionFactory.getCurrentSession().persist(medicine);
    }
    
    public void DeleteMedicine(Medicine medicine)
    {
    	Medicine medicineToDelete = (Medicine) sessionFactory.getCurrentSession().get(Medicine.class, medicine.getId());
    	sessionFactory.getCurrentSession().delete(medicineToDelete);
    }
    
    public void UpdateMedicine(Medicine medicine)
    {
    	sessionFactory.getCurrentSession().update(medicine);
    }

    @SuppressWarnings("unchecked")
	public List<Medicine> GetAllMedicines()
    {
        return sessionFactory.getCurrentSession().getNamedQuery("Medicine.getAllMedicines").list();
    }
}
