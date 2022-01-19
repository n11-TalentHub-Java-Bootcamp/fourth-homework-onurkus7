package com.onurkus.fourthhomework.service.entityservice;

import com.onurkus.fourthhomework.dao.DebtDao;
import com.onurkus.fourthhomework.entity.Debt;
import com.onurkus.fourthhomework.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class DebtEntityService extends BaseEntityService<Debt,DebtDao> {


    public DebtEntityService(DebtDao dao) {
        super(dao);
    }

    public List<Debt> findByCreatedDateBetween(Date start, Date end){
        return getDao().findByCreatedDateBetween(start,end);
    }

    public List<Debt> findDebtByUserId(Long userId){
        return getDao().findDebtByUserId(userId);
    }

    public List<Debt> findOverdueDebtByUserId(Long userId){
        return getDao().findOverdueDebtByUserId(userId);
    }

    public BigDecimal findSumOfTotalDebtByUserId(Long userId){
        return getDao().findSumOfTotalDebtByUserId(userId);
    }

    public BigDecimal findSumOfOverdueDebtByUserId(Long userId){
        return getDao().findSumOfOverdueDebtByUserId(userId);
    }

    public BigDecimal findSumOfLateFeeDebtByUserId(Long userId){
        return getDao().findSumOfLateFeeDebtByUserId(userId);
    }


}
