package mh.todo.repositoryInterface;

import mh.todo.model.TodoCategoryModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MainRepository {
    public List<TodoCategoryModel> getTodoCategory();
    public TodoCategoryModel addTodoCategory(TodoCategoryModel todoCategoryModel);
    public TodoCategoryModel modTodoCategory(TodoCategoryModel todoCategoryModel);
    public void delTodoCategory(TodoCategoryModel todoCategoryModel);
}
