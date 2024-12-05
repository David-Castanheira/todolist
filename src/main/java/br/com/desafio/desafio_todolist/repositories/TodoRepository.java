package br.com.desafio.desafio_todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.desafio_todolist.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
