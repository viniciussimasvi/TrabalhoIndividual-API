package br.org.serratec.trabalho.biblioteca.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo do livro precisa ser adicionado!")
    @Size(min = 2, max = 50, message = "A quantidade de caractere deve ser entre {min} e {max}.")
    @Column(nullable = false, length = 50)
    private String titulo;

    @NotNull(message = "Digite a quantidade de páginas do livro.")
    @Column
    private Integer qtdPaginas;

    @Embedded
    @Valid
    private Publicacao publicacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }
}
