package com.bookapi.bootrest.dao;

import org.springframework.data.repository.CrudRepository;

import com.bookapi.bootrest.entity.Books;
import java.util.List;


public interface BookRepository extends CrudRepository<Books,Integer> {
    
    public Books findByBookid(int bookid);
}
