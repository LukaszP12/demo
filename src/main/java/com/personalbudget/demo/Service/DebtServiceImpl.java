package com.personalbudget.demo.Service;

import com.personalbudget.demo.DAO.DebtDAO;
import com.personalbudget.demo.Entity.Debt;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebtServiceImpl implements DebtService {

    @Autowired
    DebtDAO debtDAO;    
    
    public DebtServiceImpl() { }    
    
    @Override
    @Transactional
    public List<Debt> getDebts() {
        return debtDAO.getDebts();
    }

    @Override
    @Transactional
    public Debt getDebt(String name) {
        return debtDAO.getDebt(name);
    }

    @Override
    @Transactional
    public int getDebtId(String name) {
        return debtDAO.getDebtId(name);
    }

    @Override
    @Transactional
    public Debt getDebtById(int id) {
        return debtDAO.getDebtById(id);
    }

    @Override
    @Transactional
    public void saveDebt(Debt theDebt) {
        debtDAO.saveDebt(theDebt);
    }

    @Override
    @Transactional
    public void deleteDebt(int id) {
        debtDAO.deleteDebt(id);
    }

    @Override
    @Transactional
    public boolean checkIfDebtExists(String debtName) {
        return debtDAO.checkIfDebtExists(debtName);
    }

    @Override
    @Transactional
    public void updateDebt(Debt theDebt) {
        debtDAO.updateDebt(theDebt);
    }

}
