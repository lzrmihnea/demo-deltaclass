package eu.crocspace.calculator.repository;

import eu.crocspace.calculator.repository.model.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CalculationRepository extends JpaRepository<OperationEntity, Long> {

    List<OperationEntity> findAllByTimeAfter(Date startTime);
}
