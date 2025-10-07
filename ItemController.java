package io.savantlabs.shoppinglist.controller;

import io.savantlabs.shoppinglist.model.Item;
import io.savantlabs.shoppinglist.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @GetMapping
    public List<Item> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return service.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
        return service.findById(id)
                .map(existing -> {
                    existing.setName(item.getName());
                    existing.setPrice(item.getPrice());
                    existing.setQuantity(item.getQuantity());
                    existing.setCategory(item.getCategory());
                    return ResponseEntity.ok(service.save(existing));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
