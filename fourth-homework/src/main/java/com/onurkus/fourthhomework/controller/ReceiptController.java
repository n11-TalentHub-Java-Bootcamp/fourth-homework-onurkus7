package com.onurkus.fourthhomework.controller;

import com.onurkus.fourthhomework.dto.receiptdto.ReceiptDto;
import com.onurkus.fourthhomework.dto.receiptdto.ReceiptUserDto;
import com.onurkus.fourthhomework.service.ReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("app/receipts")
@AllArgsConstructor
public class ReceiptController {

    private ReceiptService receiptService;

    @GetMapping("/receipts-made-date-list")
    public ResponseEntity getDebtByCreatedDate
            (@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") Date startDate,
             @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") Date endDate) {

        List<ReceiptDto> receiptDtoList =receiptService.findByReceiptDateBetween(startDate,endDate);

        return ResponseEntity.ok(receiptDtoList);
    }

    @GetMapping("/user-receipts/{userId}")
    public List<ReceiptUserDto> getDebtByUserId(@PathVariable Long userId) {
        return receiptService.findReceiptByUserId(userId);
    }

}
