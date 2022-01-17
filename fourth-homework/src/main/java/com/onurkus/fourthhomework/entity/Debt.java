package com.onurkus.fourthhomework.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="DEBT")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "userId"})
public class Debt implements BaseEntity, Serializable {

    @SequenceGenerator(name = "generator", sequenceName = "DEBT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "MAIN_DEBT_AMOUNT")
    private BigDecimal mainDebtAmount;

    @Column(name = "LAST_DEBT_AMOUNT")
    private BigDecimal lastDebtAmount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "MATURITY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maturityDate;

    @Column(name = "DEBT_TYPE")
    private String debtType;

    @Column(name = "RELATION_DEBT_ID")
    private Long relationDebtType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER",foreignKey = @ForeignKey(name = "FK_DEBT_USER_ID"))
    private User userId;

}
