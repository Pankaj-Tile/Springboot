package com.bookapi.bootrest.services;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import com.bookapi.bootrest.dao.BookRepository;
import com.bookapi.bootrest.entity.*;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
 
    public Books addBook(Books b){
         Books result=bookRepository.save(b);
         return result;
    }

    public void updateBook(Books book,int b){
        book.setBookid(b);
        bookRepository.save(book);
       
   }

    public void deleteBook(int bid){
        bookRepository.deleteById(bid);
            }
       
   




    public List <Books> getAllBooks(){
        List<Books> list=(List<Books>)this.bookRepository.findAll();
        return list;
    }
    public Books getBookbyid(int id){
        Books book=null;
        try {
            this.bookRepository.findByBookid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

 
}
