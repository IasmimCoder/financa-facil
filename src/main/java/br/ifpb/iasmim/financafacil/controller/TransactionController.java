package br.ifpb.iasmim.financafacil.controller;

import br.ifpb.iasmim.financafacil.model.dto.TransactionDTO;
import br.ifpb.iasmim.financafacil.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<TransactionDTO> create(@RequestBody TransactionDTO dto){
        TransactionDTO createdTransaction = transactionService.create(dto);
        return ResponseEntity.created(null).body(createdTransaction);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll(){
        List<TransactionDTO> transactions = transactionService.findAll();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable UUID id){
        TransactionDTO transaction = transactionService.findById(id);
        return ResponseEntity.ok(transaction);
    }

    @DeleteMapping("/{id}")
    public  void deleteById(@PathVariable UUID id){
        transactionService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> updateUser(@PathVariable UUID id, @RequestBody TransactionDTO updateTransaction){
        TransactionDTO transaction = transactionService.updateTransaction(id, updateTransaction);
        return  ResponseEntity.ok(transaction);
    }
}
