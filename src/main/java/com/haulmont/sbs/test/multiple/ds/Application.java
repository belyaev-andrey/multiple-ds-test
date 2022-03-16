package com.haulmont.sbs.test.multiple.ds;

import com.haulmont.sbs.test.multiple.ds.todos.Todo;
import com.haulmont.sbs.test.multiple.ds.todos.TodoRepository;
import com.haulmont.sbs.test.multiple.ds.topics.Topic;
import com.haulmont.sbs.test.multiple.ds.topics.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepo;

    @Autowired
    TopicRepository topicRepo;

    @Override
    public void run(String... args) throws Exception {
        Todo todo = new Todo("test");
        Todo saved = todoRepo.save(todo);
        Optional<Todo> result = todoRepo.findById(saved.getId());
        result.ifPresent(System.out::println);

        Topic topic = new Topic("test");
        Topic savedTopic = topicRepo.save(topic);
        Optional<Topic> resultTopic = topicRepo.findById(savedTopic.getId());
        resultTopic.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
