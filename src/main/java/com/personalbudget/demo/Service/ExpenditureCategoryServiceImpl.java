package com.personalbudget.demo.Service;

import com.personalbudget.demo.DAO.ExpenditureCategoryDAO;
import com.personalbudget.demo.Entity.ExpenditureCategory;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenditureCategoryServiceImpl implements ExpenditureCategoryService {

    @Autowired
    ExpenditureCategoryDAO expCatDAO;
    
    @Override
    @Transactional
    public List<ExpenditureCategory> getExpenditureCategories() {
        return expCatDAO.getExpenditureCategories();
    }

    @Override
    @Transactional
    public void saveExpenditureCategory(ExpenditureCategory expenditureCategory) {
        expCatDAO.saveExpenditureCategory(expenditureCategory);
    }

    @Override
    @Transactional
    public void deleteExpenditureCategory(String expenditureType) {
        expCatDAO.deleteExpenditureCategory(expenditureType);
    }

    @Override
    @Transactional
    public boolean isUnique(String expenditureType) {
        return expCatDAO.isUnique(expenditureType);
    }

}
