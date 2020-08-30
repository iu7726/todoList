package mh.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mh.todo.model.TodoWork;
import mh.todo.service.WorkService;

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

    @GetMapping("/api/workList")
    public List<TodoWork> workList(TodoWork todoWork){
        return this.workService.workList(todoWork);
    }

    @PostMapping("/api/workMod")
    public TodoWork workMod(TodoWork todoWork){
        return this.workService.modWork(todoWork);
    }

    @PostMapping("/api/workDel")
    public void workDel(TodoWork todoWork){
        this.workService.delWork(todoWork);
    }

}
