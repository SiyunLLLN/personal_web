package project.services;

import java.util.Optional;

import project.Entities.Book;



public interface BookService {

    public void save(Book book);


	public Iterable<Book> findAll();


	public Book findById(Long id);

}
