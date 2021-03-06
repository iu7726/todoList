package mh.todo.service;

import mh.todo.model.TodoCategoryModel;
import mh.todo.repositoryInterface.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MainService {

    private final MainRepository mainRepository;

    public MainService(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public List<TodoCategoryModel> getTodoCategory(){
        return mainRepository.getTodoCategory();
    }

    public TodoCategoryModel addTodoCategory(TodoCategoryModel todoCategoryModel){
        return mainRepository.addTodoCategory(todoCategoryModel);
    }

    public TodoCategoryModel modTodoCategory(TodoCategoryModel todoCategoryModel){
        return mainRepository.modTodoCategory(todoCategoryModel);
    }

    public void delTodoCategory(TodoCategoryModel todoCategoryModel){
        mainRepository.delTodoCategory(todoCategoryModel);
    }

}
