package eu.crocspace.calculator.service;

import eu.crocspace.calculator.controller.model.OperationDto;
import eu.crocspace.calculator.repository.CalculationRepository;
import eu.crocspace.calculator.repository.model.OperationEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimpleCalculator {

    private final CalculationRepository repository;
    private final OperationsMapper mapper;

    public SimpleCalculator(CalculationRepository calculationRepository,
                            OperationsMapper operationsMapper) {
        this.repository = calculationRepository;
        this.mapper = operationsMapper;
    }

    public BigDecimal add(BigDecimal op1, BigDecimal op2) {
        BigDecimal result = op1.add(op2);
        saveResult(op1, op2, result);
        return result;
    }

    public BigDecimal subtract(BigDecimal op1, BigDecimal op2) {
        BigDecimal result = op1.subtract(op2);
        saveResult(op1, op2, result);
        return result;
    }

    public BigDecimal multiply(BigDecimal op1, BigDecimal op2) {
        BigDecimal result = op1.multiply(op2);
        saveResult(op1, op2, result);
        return result;
    }

    public BigDecimal divide(BigDecimal op1, BigDecimal op2) {
        if (op1.equals(BigDecimal.ZERO)) {
            throw new RuntimeException("First operator cannot be 0");
        }
        BigDecimal result = op1.divide(op2);
        saveResult(op1, op2, result);
        return result;
    }

    public List<OperationDto> getAllOperationsFromLastWeek() {
        Date _1WeekAgo = Date.from(Instant.from(LocalDate.now().minusWeeks(1)));
        return this.repository.findAllByTimeAfter(_1WeekAgo)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    private void saveResult(BigDecimal op1, BigDecimal op2, BigDecimal result) {
        this.repository.save(
                OperationEntity.builder()
                        .op1(op1)
                        .op2(op2)
                        .result(result)
                        .time(Date.from(Instant.now()))
                        .build());
    }
}