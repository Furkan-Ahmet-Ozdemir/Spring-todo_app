package com.furkan.todo_app;

import com.furkan.todo_app.model.Item;
import com.furkan.todo_app.model.List;
import com.furkan.todo_app.repository.ItemRepository;
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
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateItem() {
        List list = new List(1,"Alışveriş");
        List savedList = listRepository.save(list);
        Item item = new Item(1,"Elma","safas fafs",savedList);
        Item item1 = new Item(2,"Armut","s sdgsdgafas fafs",savedList);

        itemRepository.save(item);
        itemRepository.save(item1);

        assert itemRepository.findById(item.getId()).isPresent();
        assertThat(item.getDescription()).isNotNull();
        assertThat(item1.getItemName()).isNotNull();
        assertThat(item.getItemName()).isNotEqualTo(item1.getItemName());
    }

    @Test
    public void testUpdateItem() {
        List list = new List(1,"Alışveriş");
        List savedList = listRepository.save(list);
        Item item = new Item(1,"Elma","safas fafs",savedList);
        Item item1 = new Item(2,"Armut","s sdgsdgafas fafs",savedList);

        itemRepository.save(item);
        itemRepository.save(item1);
        item.setItemName("Kavun");
        itemRepository.save(item);

        assert itemRepository.findById(item.getId()).isPresent();
        assertThat(item.getDescription()).isNotNull();
        assertThat(item1.getItemName()).isNotNull();
        assertThat(item.getItemName()).isEqualTo("Kavun");
    }

    @Test
    public void testDeleteItem() {
        List list = new List(1,"Alışveriş");
        List savedList = listRepository.save(list);
        Item item = new Item(1,"Elma","safas fafs",savedList);

        itemRepository.delete(item);
        Item savedList1 = entityManager.find(Item.class,savedList.getId());

        assertThat(savedList1).isNull();
    }

}
