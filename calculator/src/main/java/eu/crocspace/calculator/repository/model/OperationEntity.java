package eu.crocspace.calculator.repository.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "operations")
@Data
@Builder
@NoArgsConstructor
public class OperationEntity {
    @Id
    private Long id;

    @Column(name = "op_1")
    private BigDecimal op1;

    @Column(name = "op_2")
    private BigDecimal op2;

    @Column(name = "result")
    private BigDecimal result;

    @Column(name = "operator")
    private String operator;

    @Column(name = "time")
    private Date time;
}
