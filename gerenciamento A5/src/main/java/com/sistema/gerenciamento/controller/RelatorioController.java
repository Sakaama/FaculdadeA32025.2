package com.sistema.gerenciamento.controller;

import com.sistema.gerenciamento.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private LogService logService;

    @GetMapping("/percentual-conclusao")
    public String getPercentualConclusao(@RequestParam Long projetoId) {
        double percentual = logService.calcularPercentualConclusao(projetoId);
        return "O percentual de conclusão do projeto é: " + percentual + "%";
    }
}