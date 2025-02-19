package br.com.gustavo.aluno_api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavo.aluno_api.models.AlunoModel;
import br.com.gustavo.aluno_api.repository.AlunoRepository;
import br.com.gustavo.aluno_api.service.AlunoService;

@RestController
public class AlunoController {
    
    private AlunoRepository acao;
    private AlunoService alunoService;

    public AlunoController(AlunoRepository acao, AlunoService alunoService) {
        this.acao = acao;
        this.alunoService = alunoService;
    }

    //Cadastrar Aluno
    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody AlunoModel obj){
        return alunoService.cadastrar(obj);
    }

    //Selecionar pelo id
    @GetMapping("/api/{id}")
    public ResponseEntity<?> selecionarPeloId(@PathVariable int id){
        return alunoService.selecionarPeloId(id);
    }

    //Listar alunos
    @GetMapping("/api")
    public ResponseEntity<?> listarTodosAlunos() {
        return alunoService.selecionar();
    }

    //Editar aluno
    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody AlunoModel obj){
        return alunoService.editar(obj);
    }

    //Remover aluno
    @DeleteMapping("/api/{id}")
    public ResponseEntity<?> remover(@PathVariable int id){
        return alunoService.remover(id);
    }


    //Status
    @GetMapping("/api/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Contador
    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }
       
    
    
}
