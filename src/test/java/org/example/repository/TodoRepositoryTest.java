package org.example.repository;

import org.example.model.TodoEntity;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @After
    public void cleanup() {
        todoRepository.deleteAll();
    }

    @Test
    public void todoBuild() {
        String title = "할 일1";
        Long order = 1l;
        Boolean completed = false;

        todoRepository.save(TodoEntity.builder().title(title).order(order).completed(completed).build());

        List<TodoEntity> todoEntityList = todoRepository.findAll();

        TodoEntity todoEntity = todoEntityList.get(0);
        assertThat(todoEntity.getTitle()).isEqualTo(title);
        assertThat(todoEntity.getOrder()).isEqualTo(order);
        assertThat(todoEntity.getCompleted()).isEqualTo(completed);

    }
}
