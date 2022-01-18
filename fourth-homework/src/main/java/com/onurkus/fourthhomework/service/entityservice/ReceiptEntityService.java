package com.onurkus.fourthhomework.service.entityservice;

import com.onurkus.fourthhomework.dao.ReceiptDao;
import com.onurkus.fourthhomework.entity.Receipt;
import com.onurkus.fourthhomework.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReceiptEntityService extends BaseEntityService<Receipt, ReceiptDao> {

    public ReceiptEntityService(ReceiptDao dao) {
        super(dao);
    }

    public List<Receipt> findByReceiptDateBetween(Date start, Date end){
        return getDao().findByReceiptDateBetween(start,end);
    }

    public List<Receipt> findReceiptByUserId(Long userId){
        return getDao().findReceiptByUserId(userId);
    }

}
