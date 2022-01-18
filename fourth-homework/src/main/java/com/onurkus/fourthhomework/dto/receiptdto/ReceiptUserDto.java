package com.onurkus.fourthhomework.dto.receiptdto;

import com.onurkus.fourthhomework.entity.Debt;
import com.onurkus.fourthhomework.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ReceiptUserDto {

    private Long id;
    private Date receiptDate;
    private BigDecimal receiptAmount;
    private User userId;
    private Debt debt;

}
