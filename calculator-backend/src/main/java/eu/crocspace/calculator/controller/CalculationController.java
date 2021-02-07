package eu.crocspace.calculator.controller;

import eu.crocspace.calculator.controller.model.OperationDto;
import eu.crocspace.calculator.service.SimpleCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CalculationController {

    private final SimpleCalculator service;

    public CalculationController(SimpleCalculator simpleCalculator) {
        this.service = simpleCalculator;
    }

    @PostMapping("/api/add")
    public ResponseEntity<BigDecimal> add(@RequestParam(name = "op1") Long op1, @RequestParam(name = "op2") Long op2) {
        return ResponseEntity.ok(service.add(BigDecimal.valueOf(op1), BigDecimal.valueOf(op2)));
    }

    @PostMapping("/api/subtract")
    public ResponseEntity<BigDecimal> subtract(@RequestParam(name = "op1") Long op1, @RequestParam(name = "op2") Long op2) {
        return ResponseEntity.ok(service.subtract(BigDecimal.valueOf(op1), BigDecimal.valueOf(op2)));
    }

    @PostMapping("/api/multiply")
    public ResponseEntity<BigDecimal> multiply(@RequestParam(name = "op1") Long op1, @RequestParam(name = "op2") Long op2) {
        return ResponseEntity.ok(service.multiply(BigDecimal.valueOf(op1), BigDecimal.valueOf(op2)));
    }

    @PostMapping("/api/divide")
    public ResponseEntity<BigDecimal> divide(@RequestParam(name = "op1") Long op1, @RequestParam(name = "op2") Long op2) {
        return ResponseEntity.ok(service.divide(BigDecimal.valueOf(op1), BigDecimal.valueOf(op2)));
    }

    @GetMapping("/api")
    public ResponseEntity<List<OperationDto>> getAllOperationsInLastWeek() {
        return ResponseEntity.ok(service.getAllOperationsFromLastWeek());
    }

//    @GetMapping("/api/student/{id}") // Read operations
//    public Student getStudentById(@PathVariable(name = "id") Long studentId) {
//        return service.getStudentById(studentId);
//    }
//
//    @GetMapping("/api/student") // Read operations
//    public ResponseEntity<List<Student>> getStudentsBy(@RequestParam(name = "lastname", required = false) String lastname,
//                                                       @RequestParam(name = "firstname", required = false) String firstname) {
//
//        return ResponseEntity.ok(this.service.findStudentsBy(lastname, firstname));
//    }
//
//    @GetMapping("/api/students")
//    public List<Student> getAllStudents() {
//        return service.findAllStudents();
//    }
//
//    @PostMapping("/api/student") // Create operations
//    public ResponseEntity<Student> createNewStudent(@RequestBody Student studentRequest) {
//        return ResponseEntity.ok(service.createNewStudent(studentRequest));
//    }
//
//    @PutMapping("/api/student")
//    public ResponseEntity<Student> updateStudent(@RequestBody Student updateRequest) {
//        if (updateRequest.getId() == null || updateRequest.getId() <= 0) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(updateRequest);
//        }
//        return ResponseEntity.ok(service.updateStudent(updateRequest));
//    }
//
//    @DeleteMapping("/api/student/{id}")
//    public void deleteStudent(@PathVariable("id") Long idToDelete) {
//        this.service.deleteStudentById(idToDelete);
//    }
//
//    @PatchMapping("/api/student")
//    public void renameAll(@RequestBody RenameStudentsDto dto) {
//        this.service.renameAllStudents(dto.getStudentIds(), dto.getNewFirstname());
//    }
//

}
