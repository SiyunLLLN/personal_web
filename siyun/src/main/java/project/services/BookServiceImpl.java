package project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entities.Book;
import project.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	
    public void save(Book book) {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
        bookRepository.save(book);
    }



	public Iterable<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}



	public Book findById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).orElse(null);
	}

}
