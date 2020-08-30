package mh.todo.controller;

import mh.todo.model.TodoCategoryModel;
import mh.todo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/api/main")
    public List<TodoCategoryModel> apiMain(){
        return mainService.getTodoCategory();
    }

    @PostMapping("/api/addCategory")
    public TodoCategoryModel addCate(TodoCategoryModel todoCategoryModel){
        return mainService.addTodoCategory(todoCategoryModel);
    }

    @PostMapping("/api/modCategory")
    public TodoCategoryModel modCate(TodoCategoryModel todoCategoryModel){
        return mainService.modTodoCategory(todoCategoryModel);
    }

    @PostMapping("/api/delCategory")
    public void delCate(TodoCategoryModel todoCategoryModel){
        mainService.delTodoCategory(todoCategoryModel);
    }

}
