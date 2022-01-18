package com.onurkus.fourthhomework.service;

import com.onurkus.fourthhomework.converter.ReceiptMapper;
import com.onurkus.fourthhomework.dto.receiptdto.ReceiptDto;
import com.onurkus.fourthhomework.dto.receiptdto.ReceiptUserDto;
import com.onurkus.fourthhomework.entity.Receipt;
import com.onurkus.fourthhomework.service.entityservice.ReceiptEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private final ReceiptEntityService receiptEntityService;

    public List<ReceiptDto> findByReceiptDateBetween(Date start, Date end) {

        List<Receipt> receiptList = receiptEntityService.findByReceiptDateBetween(start,end);
        List<ReceiptDto> receiptDto = ReceiptMapper.INSTANCE.convertToReceiptDtoList(receiptList);

        return receiptDto;
    }

    public List<ReceiptUserDto> findReceiptByUserId (Long userId){

        List<Receipt> receiptList=receiptEntityService.findReceiptByUserId(userId);
        List<ReceiptUserDto> receiptUserDto = ReceiptMapper.INSTANCE.convertToReceiptUserDtoList(receiptList);

        return receiptUserDto;
    }
}
