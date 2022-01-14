package com.onurkus.fourthhomework.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="DEBT")
@Data
public class Debt {

    @SequenceGenerator(name = "generator", sequenceName = "DEBT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "MAIN_DEBT_AMOUNT")
    private BigDecimal mainDebtAmount;

    @Column(name = "LAST_DEBT_AMOUNT")
    private BigDecimal lastDebtAmount;

    @Column(name = "MATURITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maturityDate;

    @Column(name = "DEBT_TYPE")
    private String debtType;

    @Column(name = "RELATION_DEBT_ID")
    private Long relationDebtType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USERS",foreignKey = @ForeignKey(name = "FK_DEBT_USER_ID"))
    private User userId;


}
