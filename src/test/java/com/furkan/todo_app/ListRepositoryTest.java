package com.furkan.todo_app;

import com.furkan.todo_app.model.List;
import com.furkan.todo_app.repository.ListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ListRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ListRepository listRepository;

    @Test
    public void testCreateList() {
        List list = new List(1,"Alışveriş");
        List savedList = listRepository.save(list);

        List savedList1 = entityManager.find(List.class,savedList.getId());

        assertThat(list.getListName()).isNotNull();
        assertThat(list.getId()).isNotNull();
        assertThat(savedList.getListName()).isEqualTo(savedList1.getListName());
    }

    @Test
    public void testUpdateList() {
        List list = new List(1,"Alışveriş");
        List savedList = listRepository.save(list);

        savedList.setListName("Alışveriş----2");
        List savedList1 = listRepository.save(savedList);

        assertThat(savedList.getListName()).isEqualTo(savedList1.getListName());
    }

    @Test
    public void testDeleteList() {
        List list = new List(1,"Alışveriş");
        List savedList = listRepository.save(list);

        listRepository.delete(savedList);
        List savedList1 = entityManager.find(List.class,savedList.getId());

        assertThat(savedList1).isNull();
    }

}
