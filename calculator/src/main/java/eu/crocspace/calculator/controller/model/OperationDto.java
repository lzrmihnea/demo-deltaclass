package eu.crocspace.calculator.controller.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
public class OperationDto {
    private BigDecimal op1;
    private BigDecimal op2;
    private BigDecimal result;
    private String operator;
    private Date time;
}
