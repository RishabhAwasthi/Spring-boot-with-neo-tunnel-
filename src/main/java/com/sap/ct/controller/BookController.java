package com.sap.ct.controller;

import java.util.List;

import com.sap.ct.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sap.ct.services.BookService;

@RestController
public class BookController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping("/book/count")
    public long count() {
        log.info("Search total number of books");
        return bookService.getCount();
    }

    @RequestMapping("/book/all")
    public List<Book> getAllBooks(){
        log.info("Searching all books");
        return bookService.findAllBooks();
    }

    @RequestMapping(method=RequestMethod.POST, value = "/book/add")
    public boolean addBook(@RequestBody Book book) {

        log.info("Creation/Updating Book - "+book.toString());
        return bookService.insertBook(book);
    }

    @RequestMapping("/book/id/{id}" )
    public Book findById(@PathVariable long id) {
        log.info("Searching book with ID - "+ id);
        return bookService.findBookById(id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/book/delete/{id}")
    public boolean deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }

}
