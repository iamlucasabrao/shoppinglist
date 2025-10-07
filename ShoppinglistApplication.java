package io.savantlabs.shoppinglist;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.savantlabs.shoppinglist.model.Item;
import io.savantlabs.shoppinglist.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

@SpringBootApplication
public class ShoppinglistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppinglistApplication.class, args);
    }

    // Carregar dados iniciais do JSON
    @Bean
    CommandLineRunner loadData(ItemRepository repository) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Item>> typeRef = new TypeReference<>() {};
            List<Item> items = mapper.readValue(
                    new ClassPathResource("data.json").getInputStream(), typeRef
            );
            repository.saveAll(items);
        };
    }
}
