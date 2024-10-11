package br.org.serratec.trabalho.biblioteca.repository;

import br.org.serratec.trabalho.biblioteca.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
