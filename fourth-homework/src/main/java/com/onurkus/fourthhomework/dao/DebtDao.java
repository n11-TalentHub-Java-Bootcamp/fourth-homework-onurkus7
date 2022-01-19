package com.onurkus.fourthhomework.dao;

import com.onurkus.fourthhomework.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface DebtDao extends JpaRepository<Debt, Long> {

    List<Debt> findByCreatedDateBetween(Date start, Date end);

    @Query("SELECT debt FROM Debt debt WHERE debt.userId.id = :userId AND debt.lastDebtAmount>0")
    List<Debt> findDebtByUserId(Long userId);

    @Query("SELECT debt FROM Debt debt WHERE debt.userId.id = :userId AND DATE_PART('day',NOW()-maturityDate)>=0 AND debt.lastDebtAmount>0")
    List<Debt> findOverdueDebtByUserId(Long userId);

    @Query("SELECT SUM(lastDebtAmount) FROM Debt debt WHERE debt.userId.id")
    BigDecimal findSumOfTotalDebtByUserId(Long userId);

    @Query("SELECT SUM(lastDebtAmount) FROM Debt debt WHERE debt.userId.id = :userId AND DATE_PART('day',NOW()-maturityDate)>=0")
    BigDecimal findSumOfOverdueDebtByUserId(Long userId);

    @Query("SELECT SUM(lastDebtAmount) FROM Debt debt WHERE debt.userId.id = :userId AND debt.debtType='Overdue Debt'")
    BigDecimal findSumOfLateFeeDebtByUserId(Long userId);

}
