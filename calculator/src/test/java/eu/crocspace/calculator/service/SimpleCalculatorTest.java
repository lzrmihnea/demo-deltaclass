package eu.crocspace.calculator.service;

import eu.crocspace.calculator.repository.CalculationRepository;
import eu.crocspace.calculator.repository.model.OperationEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SimpleCalculatorTest {

    @InjectMocks
    SimpleCalculator calculator;
    @Mock
    CalculationRepository repository;
    @Spy
    OperationsMapper mapper;

    @Test
    void testAddition_expectedSaveCalledAndResultCorrect() {
        BigDecimal operator1 = BigDecimal.valueOf(55);
        BigDecimal operator2 = BigDecimal.valueOf(113);

        BigDecimal expectedResult = this.calculator.add(operator1, operator2);

        verify(repository).save(any(OperationEntity.class));
        assertEquals(BigDecimal.valueOf(168), expectedResult);
    }

    @Test
    void testSubtraction_expectedSaveCalledAndResultCorrect() {
        BigDecimal operator1 = BigDecimal.valueOf(999);
        BigDecimal operator2 = BigDecimal.valueOf(99);

        BigDecimal expectedResult = this.calculator.subtract(operator1, operator2);

        verify(repository).save(any(OperationEntity.class));
        assertEquals(BigDecimal.valueOf(900), expectedResult);
    }

    @Test
    void testMultiplication_expectedSaveCalledAndResultCorrect() {
        BigDecimal operator1 = BigDecimal.valueOf(22);
        BigDecimal operator2 = BigDecimal.valueOf(45);

        BigDecimal expectedResult = this.calculator.multiply(operator1, operator2);

        verify(repository).save(any(OperationEntity.class));
        assertEquals(BigDecimal.valueOf(990), expectedResult);
    }

    @Test
    void testDivision_expectedSaveCalledAndResultCorrect() {
        BigDecimal operator1 = BigDecimal.valueOf(20);
        BigDecimal operator2 = BigDecimal.valueOf(5);

        BigDecimal expectedResult = this.calculator.divide(operator1, operator2);

        verify(repository).save(any(OperationEntity.class));
        assertEquals(BigDecimal.valueOf(4), expectedResult);
    }

    @Test
    void testDivisionByZero_expectedException() {
        BigDecimal operator1 = BigDecimal.ZERO;
        BigDecimal operator2 = BigDecimal.valueOf(5);

        assertThrows(RuntimeException.class, () -> this.calculator.divide(operator1, operator2));
    }

}