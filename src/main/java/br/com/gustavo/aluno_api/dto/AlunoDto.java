package br.com.gustavo.aluno_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoDto(@NotBlank String nome, @NotNull double nota1, @NotNull double nota2) {

    
}
