package mh.todo.repositoryInterface;

import mh.todo.model.TodoWork;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository {
    public Boolean workAdd(TodoWork todoWork);
}
