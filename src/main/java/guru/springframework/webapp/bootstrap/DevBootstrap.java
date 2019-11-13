package guru.springframework.webapp.bootstrap;

import guru.springframework.webapp.model.Author;
import guru.springframework.webapp.model.Book;
import guru.springframework.webapp.model.Publisher;
import guru.springframework.webapp.repositories.AuthorRepository;
import guru.springframework.webapp.repositories.BookRepository;
import guru.springframework.webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("Harper Collins");
        publisherRepository.save(publisher);


        Author eric = new Author("Eric", "Evans");
        Book ericBook = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ericBook);


        Publisher publisher1 = new Publisher();
        publisher1.setName("Worx");
        publisherRepository.save(publisher1);

        Author rod = new Author("Rod", "Johnson");
        Book rodBook = new Book("J2EE Developemnt", "2344", publisher1);
        rod.getBooks().add(rodBook);

        authorRepository.save(rod);
        bookRepository.save(rodBook);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       initData();
    }
}
