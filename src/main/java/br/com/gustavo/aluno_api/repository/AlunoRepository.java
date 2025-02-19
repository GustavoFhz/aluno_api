package br.com.gustavo.aluno_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gustavo.aluno_api.models.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer>{

    List<AlunoModel> findByOrderByNome();

    int countById(int id);

    // Lista alunos que possuem uma média maior ou igual ao valor passado
@Query("SELECT a FROM AlunoModel a WHERE (a.nota1 + a.nota2) / 2 >= :media")
List<AlunoModel> buscarAlunosPorMedia(@Param("media") Double media);


    
}
