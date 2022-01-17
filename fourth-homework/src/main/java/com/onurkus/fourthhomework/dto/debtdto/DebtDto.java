package com.onurkus.fourthhomework.dto.debtdto;

import com.onurkus.fourthhomework.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DebtDto {

    private Long id;
    private BigDecimal mainDebtAmount;
    private BigDecimal lastDebtAmount;
    private Date createdDate;
    private Date maturityDate;
    private String debtType;
    private Long relationDebtType;
    private User userId;
}
