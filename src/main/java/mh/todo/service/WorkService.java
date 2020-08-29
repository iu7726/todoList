package mh.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mh.todo.model.TodoWork;
import mh.todo.repositoryInterface.WorkRepository;

@Transactional
@Service
public class WorkService {
    private final WorkRepository workRepository;

    public WorkService(WorkRepository workRepository){
        this.workRepository = workRepository;
    }

    public TodoWork addWork(TodoWork todoWork){
        return this.workRepository.workAdd(todoWork);
    }

    public List<TodoWork> workList(TodoWork todoWork){
        return this.workRepository.workList(todoWork);
    }

    public TodoWork modWork(TodoWork todoWork){
        return this.workRepository.workMod(todoWork);
    }
}
