package com.marek.spring.guru1.repositories;

import com.marek.spring.guru1.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
