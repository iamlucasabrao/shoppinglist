package io.savantlabs.shoppinglist.service;

import io.savantlabs.shoppinglist.model.Item;
import io.savantlabs.shoppinglist.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import io.savantlabs.shoppinglist.exception.ItemNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public List<Item> findAll() {
        return repository.findAll();
    }

    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id)));
    }

    public Item save(Item item) {
        return repository.save(item);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
