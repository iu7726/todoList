package mh.todo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mh.todo.model.TodoWork;
import mh.todo.service.WorkService;

@SpringBootTest
class TodoApplicationTests {

	@Autowired
	WorkService workService;

	@Test
	void addWork() {

		TodoWork todoWork = new TodoWork();

		/*
		GROUP_ID: 1
		ID: 0
		TU_ID: "1"
		TW_CONTENTS: "텟텟↵테테↵텟↵테텟"
		TW_END: "2020-08-21"
		TW_START: "2020-08-19"
		TW_TITLE: "테스트"
		*/

		todoWork.setTU_ID(1);
		todoWork.setTW_CONTENTS("텟텟↵테테↵텟↵테텟");
		todoWork.setTW_END("2020-08-21");
		todoWork.setTW_START("2020-08-19");
		todoWork.setTW_TITLE("테스트");
		todoWork.setGROUP_ID(1);
		todoWork.setCATEGORY_ID(2);
		todoWork.setTW_CHECK(0);

		TodoWork todoWork1 = workService.addWork(todoWork);

		assertThat(todoWork.getTW_TITLE()).isEqualTo(todoWork1.getTW_TITLE());

	}

	@Test
	void 할일조회(){

		TodoWork todoWork = new TodoWork();

		todoWork.setGROUP_ID(1);
		todoWork.setTU_ID(1);
		todoWork.setCATEGORY_ID(2);

		List<TodoWork> workList = workService.workList(todoWork);

		assertThat(workList.get(0).getId()).isEqualTo(8);

	}

	@Test
	void 할일수정(){
		TodoWork todoWork = new TodoWork();
		todoWork.setId(8);
		todoWork.setTW_CONTENTS("변경해봤습니다.");
		todoWork.setTW_END("2020-09-03 11:11:11");
		todoWork.setTW_START("2020-09-02 09:11:11");
		todoWork.setTW_TITLE("변경");
		todoWork.setCATEGORY_ID(2);
		todoWork.setTW_CHECK(1);

		TodoWork modWork = workService.modWork(todoWork);

		assertThat(modWork.getId()).isEqualTo(todoWork.getId());
	}
}
