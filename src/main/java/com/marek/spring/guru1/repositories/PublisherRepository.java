package com.marek.spring.guru1.repositories;

import com.marek.spring.guru1.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
