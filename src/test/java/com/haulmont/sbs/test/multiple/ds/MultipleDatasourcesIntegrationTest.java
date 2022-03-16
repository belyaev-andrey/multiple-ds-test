package com.haulmont.sbs.test.multiple.ds;

import com.haulmont.sbs.test.multiple.ds.todos.Todo;
import com.haulmont.sbs.test.multiple.ds.todos.TodoRepository;
import com.haulmont.sbs.test.multiple.ds.topics.Topic;
import com.haulmont.sbs.test.multiple.ds.topics.TopicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // no test database!
class MultipleDatasourcesIntegrationTest {

    @Autowired
    TodoRepository todoRepo;
    @Autowired
    TopicRepository topicRepo;

    @Test
    void shouldSaveTodoToTodoDB() {
        Todo todo = new Todo("test");
        Todo saved =todoRepo.save(todo);
        Optional<Todo> result= todoRepo.findById(saved.getId());
        assertThat(result).isPresent();
    }

    @Test
    void shouldSaveTopicToTopicDB() {
        Topic topic = new Topic("test");
        Topic saved =topicRepo.save(topic);
        Optional<Topic> result= topicRepo.findById(saved.getId());
        assertThat(result).isPresent();
    }

}
