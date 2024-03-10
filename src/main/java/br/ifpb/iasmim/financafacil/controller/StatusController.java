package br.ifpb.iasmim.financafacil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Quando acessado via HTTP GET em "/api/status", retorna um objeto JSON com informações sobre o status de um serviço 
 * chamado "FinancaFacil". O status é definido como "up", e o código de status HTTP é 200 (OK).
 */

@RestController //Indica que a classe é um controlador REST, ou seja, é responsável por lidar com requisições HTTP e retornar respostas no formato adequado para a web.
@RequestMapping("/api") // Especifica que todas as rotas definidas nesta classe terão "/api" como prefixo.
public class StatusController {

    @GetMapping("status") //Indica que este método responderá a requisições HTTP do tipo GET para a rota "/api/status".
    public ResponseEntity<HashMap<String, Object>> getApiStatus(){
        
        var response = new HashMap<String, Object>();

        response.put("service", "FinancaFacil");
        response.put("status", "up");
        response.put("httpStatus", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }
}
