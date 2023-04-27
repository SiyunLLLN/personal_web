package project.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.Entities.Book;



public interface BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findByTitle(String title);
    
    public Optional<Book> findById(Long id);
    
    
//    public Book findById(long id);

}