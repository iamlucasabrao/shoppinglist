package io.savantlabs.shoppinglist.repository;

import io.savantlabs.shoppinglist.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}
