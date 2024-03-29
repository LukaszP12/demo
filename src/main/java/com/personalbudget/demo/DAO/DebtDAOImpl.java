package com.personalbudget.demo.DAO;

import com.personalbudget.demo.Entity.Debt;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class DebtDAOImpl implements DebtDAO {

    
    private EntityManager entityManager;
    
    @Autowired
    public DebtDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    
    @Override
    public List<Debt> getDebts() {
        Session currentSession = entityManager.unwrap(Session.class);
        
        // get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();        
        String username = auth.getName();
        
        Query<Debt> theQuery = currentSession.createQuery("from debts WHERE username='" + username + "'", Debt.class);
        List<Debt> debts = (List<Debt>) theQuery.getResultList();
        
        return debts;
    }

    @Override
    public Debt getDebt(String name) {
        Session currentSession = entityManager.unwrap(Session.class);
        
        // get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();        
        String username = auth.getName();
        
        Query<Debt> theQuery = currentSession.createQuery("from debts WHERE username='" + username + "' AND debt_name='" + name + "'", Debt.class);
        Debt debt = (Debt) theQuery.getSingleResult();
        
        return debt;
    }

    @Override
    public int getDebtId(String name) {
        Session currentSession = entityManager.unwrap(Session.class);
        
        // get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();        
        String username = auth.getName();
        
        Query<Debt> theQuery = currentSession.createQuery("from debts WHERE username='" + username + "' AND debt_name='" + name + "'", Debt.class);
        Debt debt = (Debt) theQuery.getSingleResult();
        int id = debt.getDebtId();
        
        return id;
    }

    @Override
    public Debt getDebtById(int id) {
         Session currentSession = entityManager.unwrap(Session.class);
                
        Query<Debt> theQuery = currentSession.createQuery("from debts WHERE debt_id='" + id + "'", Debt.class);
        Debt debt = (Debt) theQuery.getSingleResult();
        
        return debt;
    }

    @Override
    public void saveDebt(Debt theDebt) {
        Session currentSession = entityManager.unwrap(Session.class);  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();        
        String username = auth.getName();
        theDebt.setUsername(username);
        
        currentSession.save(theDebt);        
    }

    @Override
    public void deleteDebt(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();        
        String username = auth.getName();        
        Query<Debt> theQuery = currentSession.createQuery("from debts WHERE (debt_id='" + id + "' and username='" + username + "')", Debt.class);
        Debt debt = (Debt) theQuery.getSingleResult();
        
        currentSession.delete(debt);
    }

    @Override
    public boolean checkIfDebtExists(String debtName) {
        Session currentSession = entityManager.unwrap(Session.class);
        
        // get username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();        
        String username = auth.getName();
        
        Query<Debt> theQuery = currentSession.createQuery("from debts WHERE username='" + username + "' AND debt_name='" + debtName + "'", Debt.class);
        
        List<Debt> debts = (List<Debt>) theQuery.getResultList();
        
        if (debts.isEmpty())
            return false;

        return true;
    }

    @Override
    public void updateDebt(Debt theDebt) {
        Session currentSession = entityManager.unwrap(Session.class);
        
        currentSession.saveOrUpdate(theDebt);
    }

}
