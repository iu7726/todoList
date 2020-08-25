package mh.todo.repository;

import mh.todo.model.TodoWork;
import mh.todo.repositoryInterface.WorkRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Transactional
@Repository
public class WorkJpaRepository implements WorkRepository {

    private final EntityManager em;

    public WorkJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public TodoWork workAdd(TodoWork todoWork) {

        System.out.println(todoWork.getTW_TITLE());
        System.out.println(todoWork.getTW_CONTENTS());

        em.persist(todoWork);
        em.flush();

        return todoWork;
    }
}
