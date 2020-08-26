package mh.todo.repositoryInterface;

import java.util.List;

import org.springframework.stereotype.Repository;

import mh.todo.model.TodoWork;

@Repository
public interface WorkRepository {
    public TodoWork workAdd(TodoWork todoWork);
    public List<TodoWork> workList(TodoWork todoWork);
}
