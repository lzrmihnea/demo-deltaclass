package eu.crocspace.calculator.service;

import eu.crocspace.calculator.controller.model.OperationDto;
import eu.crocspace.calculator.repository.model.OperationEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OperationsMapper {
    OperationDto entityToDto(OperationEntity entity);
}
