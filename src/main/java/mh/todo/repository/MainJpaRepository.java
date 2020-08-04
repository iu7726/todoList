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
}
