package com.onurkus.fourthhomework.dao;

import com.onurkus.fourthhomework.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReceiptDao extends JpaRepository<Receipt, Long> {

    List<Receipt> findByReceiptDateBetween(Date start, Date end);

    @Query("SELECT receipt FROM Receipt receipt WHERE receipt.userId.id = :userId")
    List<Receipt> findReceiptByUserId(Long userId);
}
