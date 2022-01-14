package com.onurkus.fourthhomework.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "RECEIPT")
@Data
public class Receipt {
    @SequenceGenerator(name = "generator", sequenceName = "RECEIPT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "RECEIPT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiptDate;

    @Column(name = "RECEIPT_AMOUNT")
    private BigDecimal receiptAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USERS",foreignKey = @ForeignKey(name = "FK_DEBT_USER_ID"))
    private User userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DEBT",foreignKey = @ForeignKey(name = "FK_RECEIPT_DEBT_ID"))
    private Debt debtId;
}
