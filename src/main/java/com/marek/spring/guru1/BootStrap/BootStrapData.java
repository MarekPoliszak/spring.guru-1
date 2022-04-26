package com.marek.spring.guru1.BootStrap;

import com.marek.spring.guru1.model.Author;
import com.marek.spring.guru1.model.Book;
import com.marek.spring.guru1.model.Publisher;
import com.marek.spring.guru1.repositories.AuthorRepository;
import com.marek.spring.guru1.repositories.BookRepository;
import com.marek.spring.guru1.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher marek = new Publisher();
        marek.setName("Marek Inc");
        marek.setAddressLine("Jastrzebia");
        marek.setCity("Lubin");
        marek.setZipCode("59300");
        publisherRepository.save(marek);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "23131");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(marek);
        marek.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(marek);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println(marek.getName());
        System.out.println("Number of publisher's books: " + publisherRepository.count());

    }
}
