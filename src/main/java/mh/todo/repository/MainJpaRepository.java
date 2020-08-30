package mh.todo.repository;

import mh.todo.model.TodoCategoryModel;
import mh.todo.repositoryInterface.MainRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class MainJpaRepository implements MainRepository {

    private final EntityManager em;

    public MainJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TodoCategoryModel> getTodoCategory() {

        return em.createQuery("SELECT todo FROM TodoCategory AS todo WHERE todo.users_id = :users_id", TodoCategoryModel.class)
                .setParameter("users_id", 1)
                .getResultList();
    }

    @Override
    public TodoCategoryModel addTodoCategory(TodoCategoryModel todoCategoryModel) {
        // TODO Auto-generated method stub
        em.persist(todoCategoryModel);
        em.flush();

        return todoCategoryModel;
    }

    @Override
    public TodoCategoryModel modTodoCategory(TodoCategoryModel todoCategoryModel) {
        // TODO Auto-generated method stub

        TodoCategoryModel modModel = em.find(TodoCategoryModel.class, todoCategoryModel.getId());

        modModel.setCate_name(todoCategoryModel.getCate_name());

        return modModel;
    }

    @Override
    public void delTodoCategory(TodoCategoryModel todoCategoryModel) {
        // TODO Auto-generated method stub
        TodoCategoryModel delModel = em.find(TodoCategoryModel.class, todoCategoryModel.getId());
        em.remove(delModel);
    }
}
