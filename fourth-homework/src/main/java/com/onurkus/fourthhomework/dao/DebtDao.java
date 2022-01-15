package com.onurkus.fourthhomework.dao;

import com.onurkus.fourthhomework.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtDao extends JpaRepository<Debt, Long> {
}
