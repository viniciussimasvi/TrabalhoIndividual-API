package br.org.serratec.trabalho.biblioteca.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Embeddable
public class Publicacao {

    @NotBlank(message = "O autor do livro precisa ser adicionado!")
    @Size(min = 2, max = 30, message = "A quantidade de caracteres deve ser entre {min} e {max}.")
    private String autor;

    private LocalDate dataPublicacao;

    private String editora;

    public @NotBlank(message = "O autor do livro precisa ser adicionado!") @Size(min = 2, max = 30,
            message = "A quantidade de caracteres deve ser entre {min} e {max}.") String getAutor() {

        return autor;
    }

    public void setAutor(@NotBlank(message = "O autor do livro precisa ser adicionado!") @Size(min = 2, max = 30,
            message = "A quantidade de caracteres deve ser entre {min} e {max}.") String autor) {

        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
