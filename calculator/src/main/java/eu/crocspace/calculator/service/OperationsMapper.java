package eu.crocspace.calculator.service;

import eu.crocspace.calculator.controller.model.OperationDto;
import eu.crocspace.calculator.repository.model.OperationEntity;
import org.springframework.stereotype.Service;

@Service
public interface OperationsMapper {
    default OperationDto entityToDto(OperationEntity entity) {
        return OperationDto.builder()
                .op1(entity.getOp1())
                .op2(entity.getOp2())
                .result(entity.getResult())
                .time(entity.getTime())
                .operator(entity.getOperator())
                .build();
    }
}
