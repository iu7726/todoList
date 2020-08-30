package mh.todo;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import mh.todo.model.TodoCategoryModel;
import mh.todo.repositoryInterface.MainRepository;
import mh.todo.service.MainService;


@SpringBootTest
@Transactional
public class MainServiceTest {

    @Autowired
    MainService mainService;

    @Autowired
    MainRepository mainRepository;

    @Test
    void getCategory(){

        mainService.getTodoCategory();

    }

    @Test
    void 카테고리추가수정(){

        TodoCategoryModel todoCategoryModel = new TodoCategoryModel();

        todoCategoryModel.setCate_name("테스트");
        todoCategoryModel.setUsers_id(1);

        TodoCategoryModel target = mainService.addTodoCategory(todoCategoryModel);

        assertThat(target.getCate_name()).isEqualTo(todoCategoryModel.getCate_name());

        target.setCate_name("테스트2");

        TodoCategoryModel target2 = mainService.modTodoCategory(target);

        assertThat(target.getCate_name()).isEqualTo(target2.getCate_name());

    }

}
