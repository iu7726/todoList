package mh.todo;

import mh.todo.model.TodoWork;
import mh.todo.service.WorkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

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

		todoWork.setTu_id(1);
		todoWork.setTw_contents("텟텟↵테테↵텟↵테텟");
		todoWork.setTw_end("2020-08-21");
		todoWork.setTw_start("2020-08-19");
		todoWork.setTw_title("테스트");
		todoWork.setGroup_id(1);

		TodoWork todoWork1 = workService.addWork(todoWork);

		assertThat(todoWork.getTw_title()).isEqualTo(todoWork1.getTw_title());

	}

}
