package com.personalbudget.demo.Service;

import com.personalbudget.demo.Entity.Currency;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    
    @Autowired
    private EntityManager entityManager;

    public CurrencyServiceImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    
    
    @Override
    @Transactional
    public List<Currency> getCurrencies() {
        Session currentSession = entityManager.unwrap(Session.class);
        
        Query<Currency> theQuery = currentSession.createQuery("from currency", Currency.class);
        
        List<Currency> currencies = (List<Currency>) theQuery.getResultList();
        
        return currencies;        
    }

}
