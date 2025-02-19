package br.com.gustavo.aluno_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.gustavo.aluno_api.models.AlunoModel;
import br.com.gustavo.aluno_api.models.Mensagem;
import br.com.gustavo.aluno_api.repository.AlunoRepository;

@Service
public class AlunoService {
    
    private Mensagem mensagem;
    private AlunoRepository acao;


    public AlunoService(Mensagem mensagem, AlunoRepository acao) {
        this.mensagem = mensagem;
        this.acao = acao;
    }

   
     // Método para cadastrar alunos
     public ResponseEntity<?> cadastrar(AlunoModel obj){

        if (obj.getNome().equals("")) {
            mensagem.setMensagem("O nome do aluno precisa ser preenchido");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (obj.getNota1() <0 || (obj.getNota2() < 0)) {
            mensagem.setMensagem("Nota não pode ser menor que 0");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
     }

     // Método para selecionar os alunos
     public ResponseEntity<List<AlunoModel>> selecionar() {
        List<AlunoModel> alunos = acao.findAll();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
        
     }

    //Método para selecionar um aluno pelo ID e incluir a média
    public ResponseEntity<AlunoModel> selecionarPeloId(int id) {
    Optional<AlunoModel> alunoOpt = acao.findById(id);
    if (alunoOpt.isEmpty()) {
        mensagem.setMensagem("Não foi encontrado nenhum aluno com esse id");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else {
        AlunoModel aluno = alunoOpt.get();
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }
}

     // Método para editar dados
     public ResponseEntity<?> editar(AlunoModel obj){

        if(acao.countById(obj.getId()) == 0){
            mensagem.setMensagem("O id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getNome() == ""){
            mensagem.setMensagem("É necessario informar um nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getNota1() < 0 || obj.getNota2() < 0){
            mensagem.setMensagem("Nota não pode ser menor que 0");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
     }

     // Método para remover registros
     public ResponseEntity<?> remover(int id){

        if (acao.countById(id) == 0) {
            mensagem.setMensagem("O id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else{
            AlunoModel obj = acao.findById(id).orElse(null);
            acao.delete(obj);
        }
        mensagem.setMensagem("Aluno removido com sucesso!");
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
     }

     



}
