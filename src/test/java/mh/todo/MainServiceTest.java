package mh.todo;

import mh.todo.model.TodoCategoryModel;
import mh.todo.repositoryInterface.MainRepository;
import mh.todo.service.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

}
