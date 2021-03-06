package mh.todo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mh.todo.model.TodoWork;
import mh.todo.repositoryInterface.WorkRepository;

@Transactional
@Repository
public class WorkJpaRepository implements WorkRepository {

    private final EntityManager em;

    public WorkJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public TodoWork workAdd(TodoWork todoWork) {

        em.persist(todoWork);
        em.flush();

        return todoWork;
    }

    @Override
    public List<TodoWork> workList(TodoWork todoWork) {
        // TODO Auto-generated method stub

        return em.createQuery("SELECT todo FROM TodoWork AS todo WHERE todo.TU_ID = :tu_id AND todo.GROUP_ID = :group_id AND todo.CATEGORY_ID = :category_id", TodoWork.class)
                .setParameter("tu_id", todoWork.getTU_ID())
                .setParameter("group_id", todoWork.getGROUP_ID())
                .setParameter("category_id", todoWork.getCATEGORY_ID())
                .getResultList();
    }

    @Override
    public TodoWork workMod(TodoWork todoWork) {
        TodoWork modWork = em.find(TodoWork.class, todoWork.getId());

        modWork.setTW_START(todoWork.getTW_START());
        modWork.setTW_END(todoWork.getTW_END());
        modWork.setTW_TITLE(todoWork.getTW_TITLE());
        modWork.setTW_CONTENTS(todoWork.getTW_CONTENTS());
        modWork.setCATEGORY_ID(todoWork.getCATEGORY_ID());
        modWork.setTW_CHECK(todoWork.getTW_CHECK());
        return modWork;
    }

    @Override
    public Boolean workDel(TodoWork todoWork) {
        // TODO Auto-generated method stub

        TodoWork delWork = em.find(TodoWork.class, todoWork.getId());

        em.remove(delWork);

        return true;
    }
}
