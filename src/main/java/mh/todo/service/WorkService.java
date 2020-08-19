package mh.todo.service;

import mh.todo.model.TodoWork;
import mh.todo.repositoryInterface.WorkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
