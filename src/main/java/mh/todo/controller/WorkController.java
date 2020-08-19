package mh.todo.controller;

import mh.todo.model.TodoWork;
import mh.todo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {

    private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService){
        this.workService = workService;
    }

    @PostMapping("/api/workAdd")
    public TodoWork addWork(TodoWork todoWork){
       return this.workService.addWork(todoWork);
    }

}
