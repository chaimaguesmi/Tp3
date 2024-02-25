package com.example.Tp3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class DemoApplicationTests {
    @Autowired
    ClientRepository repository;
    @Test
    void contextLoads() {
    }
    @Test
    public void testRepository(){
        Client c =new Client();
        c.setAge(20);
        c.setNom("Adel");
        repository.save(c);
        assertEquals( 1 ,repository.findAll().size());
        Client loadedClient = repository.findById(c.getId()).get();
        assertEquals("Adel", loadedClient.getNom());
        assertEquals(20, loadedClient.getAge());
        c.setNom("Mourad");
        repository.save(c);
        Client updatedClient = repository.findById(c.getId()).get();
        assertEquals("Mourad", updatedClient.getNom());
        assertEquals(20, updatedClient.getAge());
        repository.delete(c);
        assertEquals( 0 ,repository.findAll().size());
    }
}