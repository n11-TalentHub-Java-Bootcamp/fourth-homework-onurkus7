package com.onurkus.fourthhomework.dao;

import com.onurkus.fourthhomework.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptDao extends JpaRepository<Receipt, Long> {
}
