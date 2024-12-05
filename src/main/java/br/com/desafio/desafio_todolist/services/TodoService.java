package br.com.desafio.desafio_todolist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.desafio.desafio_todolist.entities.Todo;
import br.com.desafio.desafio_todolist.repositories.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private final TodoRepository todoRepository;

    // Injeção de dependência por construtor referente à camada 'Repository'
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        // Ordenação de prioridade (da mais alta a mais baixa)
        // e alfabética (ou seja, do menor para o maior)
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
