package com.bookapi.bootrest.services;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import java.util.*;
import com.bookapi.bootrest.entity.*;

@Component
public class BookService {
    private static List <Books> list =new ArrayList<>();
    static{
        list.add(new Books(12,"java ","ketan"));
        list.add(new Books(11,"javal ","ketan1"));
        list.add(new Books(10,"javam ","ketan2"));
    }
    public Books addBook(Books b){
         list.add(b);
         return b;
    }

    public void updateBook(Books book,int b){
        list=list.stream().map(d->{
            if(d.getBookid()==book.getBookid())
            d.setAuthor(book.getAuthor());
            d.setTitle(book.getTitle());
            return d;
        }).collect(Collectors.toList());
       
   }

    public void deleteBook(int bid){
        list=list.stream().filter(book -> book.getBookid()!=bid).collect(Collectors.toList());
        }
       
   

//     public void deleteBook(int bid){
//         list=list.stream().filter(book->{
//             if(book.getBookid()!=bid){
//                 return true;
//             }
//             else{
//                 return false;
//             }
           
//         }).collect(Collectors.toList());
       
//    }


    public List <Books> getAllBooks(){
        return list;
    }
    public Books getBookbyid(int id){
        Books book=null;
        try {
            book=list.stream().filter(e->e.getBookid()==id).findFirst().get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // // code of getBookbyid before status code embadded
    // public Books getBookbyid(int id){
    //     Books book=null;
    //     book=list.stream().filter(e->e.getBookid()==id).findFirst().get();
    //     return book;
    // }


}
