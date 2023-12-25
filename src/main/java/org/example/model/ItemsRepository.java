package org.example.model;

import org.springframework.data.repository.CrudRepository;

public interface ItemsRepository extends CrudRepository<Items, String> {
}
