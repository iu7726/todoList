package mh.todo.repository;

import mh.todo.model.TodoWork;
import mh.todo.repositoryInterface.WorkRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Repository
public class WorkJpaRepository implements WorkRepository {

    private final EntityManager em;

    public WorkJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Boolean workAdd(TodoWork todoWork) {



        return null;
    }
}
