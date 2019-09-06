package com.sap.ct.services;

import java.util.ArrayList;
import java.util.List;

import com.sap.ct.models.Book;
import com.sap.ct.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public long getCount() {
        long count = bookRepository.count();
        return count;
    }

    public List<Book> findAllBooks(){
        List<Book> employee = new ArrayList<>();
        bookRepository.findAll().forEach(employee::add);
        return employee;
    }

    public boolean insertBook(Book book) {
        try {
            bookRepository.save(book);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }

    public boolean deleteBook(long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book!=null) {
            bookRepository.delete(book);
            return true;
        }
        return false;
    }
}
