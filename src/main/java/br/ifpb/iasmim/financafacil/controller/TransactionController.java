package br.ifpb.iasmim.financafacil.controller;

import br.ifpb.iasmim.financafacil.model.dto.MonthlySummaryDTO;
import br.ifpb.iasmim.financafacil.model.dto.TransactionDTO;
import br.ifpb.iasmim.financafacil.model.enums.TransactionType;
import br.ifpb.iasmim.financafacil.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<TransactionDTO> create(@RequestBody TransactionDTO dto) {
        TransactionDTO createdTransaction = transactionService.create(dto);
        return ResponseEntity.created(null).body(createdTransaction);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll() {
        List<TransactionDTO> transactions = transactionService.findAll();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable UUID id) {
        TransactionDTO transaction = transactionService.findById(id);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/findByMonth")
    public ResponseEntity<List<TransactionDTO>> findByMonth(
            @RequestParam(value = "userId", required = true) UUID userId,
            @RequestParam(value = "month", required = false)  String month,
            @RequestParam(value = "year", required = false, defaultValue = "0") int year,
            @RequestParam("type") TransactionType type) {
        int yearWithDefault = (year == 0)? LocalDate.now().getYear() : year;

        List<TransactionDTO> transactions = transactionService.findByMonthAndType(month, yearWithDefault, type, userId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/monthlySummary")
    public ResponseEntity<MonthlySummaryDTO> monthlySummary(
        @RequestParam(value = "userId", required = true) UUID userId,       
        @RequestParam(value = "month", required = false) String month,
        @RequestParam(value = "year", required = false, defaultValue = "0") int year
        ) {
            int yearWithDefault = (year == 0)? LocalDate.now().getYear() : year;

            MonthlySummaryDTO monthlySummaryDTO = transactionService.getMonthlySummary(month, yearWithDefault, userId);
        return ResponseEntity.ok(monthlySummaryDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        transactionService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> updateUser(@PathVariable UUID id,
            @RequestBody TransactionDTO updateTransaction) {
        TransactionDTO transaction = transactionService.updateTransaction(id, updateTransaction);
        return ResponseEntity.ok(transaction);
    }
}
