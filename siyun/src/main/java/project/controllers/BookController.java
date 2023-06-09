package project.controllers;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import project.Entities.Book;
import project.Repository.BookRepository;
import project.services.BookService;

@Controller
@RequestMapping("/books/")
public class BookController {

//	if your repository is an iterface no need to add autowired
	@Autowired
    private BookService bookService;
    
//    private BookService bookService;

    @GetMapping
    public Iterable findAll() {
        return bookService.findAll();
    }
    
    @GetMapping("/{id}")
    public String one_book(@PathVariable Long id, Model model) {
    	model.addAttribute("books", bookService.findById(id) );
    	
    	return "books/book";
    }
    
    
    @GetMapping("new_book")
    public String show_Form(Book book, Model model) {
    	return "books/add_book";
    }
    
    @PostMapping("add")
    public ModelAndView addBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/books/new_book");
        }

        bookService.save(book);
        return new ModelAndView("redirect:/");
    }
    
    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {
    	
//    	System.out.println("ewrwer");

        model.addAttribute("book", bookService.findById(id));

        return "books/update_book";
    }
    
    @PostMapping("update/{id}")
    public ModelAndView updateBook(@PathVariable Long id, Book book, BindingResult result, Model model) {
//        book = bookService.findById(id);
    	
//    	if we don't have it, since in the form there is no input
//    	it will create a new one
    	book.setId(id);
    	bookService.save(book);

        return new ModelAndView("redirect:/");
    }
    

    @GetMapping("/title/")
    public ModelAndView findByTitle(@RequestParam String name, Model model) {
//    	model.addAttribute("book", bookRepository.findByTitle(name));
    	System.out.println("xixi");
//    	Note we can only return the html within the same controlloer
//    	if we want to return to the html in another control
//    	use this
    	
//    	we can also pass value to another control
//    	see: https://stackoverflow.com/questions/49122495/how-to-pass-model-data-from-one-controller-to-another-controller-spring
        return new ModelAndView("redirect:/");
    }


}