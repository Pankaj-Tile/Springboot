package com.bookapi.bootrest.controller;

import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.bootrest.entity.Books;
import com.bookapi.bootrest.services.BookService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;


@RestController  // in rest controller no need to write responsebody anotation
public class BookController {
    @Autowired
    private BookService bookService;

     @GetMapping("/books")
    public ResponseEntity<java.util.List<Books>> getBooks() {
      java.util.List<Books> list=this.bookService.getAllBooks();
      if(list.size()<=0){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         //build is building objects
      }
      return ResponseEntity.of(Optional.of(list));
    }
   //  @GetMapping("/books")
   //  public java.util.List<Books> getBooks(){
   //     return this.bookService.getAllBooks();
   //  }


   //get single book
   
   @GetMapping("/book/{id}")
   public ResponseEntity<Books> getBooks(@PathVariable("id") int id){
      Books books=this.bookService.getBookbyid(id);
      if(books==null){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
       return ResponseEntity.of(Optional.of(books));
    }



   //  @GetMapping("/book/{id}")
   //  public Books getBooks(@PathVariable("id") int id){
   //      return this.bookService.getBookbyid(10);
   //   }


      //new book posting

      @PostMapping("/books")
        public ResponseEntity<Books> addBooks(@RequestBody Books book){
            Books b=null;
            try{
               b=this.bookService.addBook(book);
               System.out.println(b.getBookid());
               return ResponseEntity.of(Optional.of(b));
            }catch(Exception e){
               e.printStackTrace();
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
         
         }

// code before status code embadded 
   //   @PostMapping("/books")
   //   public Books addBooks(@RequestBody Books book){
   //       return this.bookService.addBook(book);
   //    }


   @DeleteMapping("/books/{bookid}")
      public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int book){
         try {
            this.bookService.deleteBook(book);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
         } catch (Exception e) {
            // TODO: handle exception
            e.fillInStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
        

      }




      // code before status code embadded 
      // @DeleteMapping("/books/{bookid}")
      // public void deleteBook(@PathVariable("bookid") int book){
      //    this.bookService.deleteBook(book);
      // }



      @PutMapping("/books/{bookid}")
      public ResponseEntity<Books> updateBook(@RequestBody Books book,@PathVariable("bookid") int bookid){
         try {
            this.bookService.updateBook(book,bookid);
            return ResponseEntity.ok().body(book);
         } catch (Exception e) {
            // TODO: handle exception
            e.fillInStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
        

      }

      // code before status code embadded 
      // @PutMapping("/books/{bookid}")
      // public void updateBook(@RequestBody Books book,@PathVariable("bookid") int bookid){
      //    this.bookService.updateBook(book,bookid);
      // }

    
}






// @RestController  // in rest controller no need to write responsebody anotation
// public class BookController {
    
//     @GetMapping("/books")
//     public Books getBooks(){
//         Books book= new Books();
//         book.setBookid(1);
//         book.setAuthor("sai");
//         book.setTitle("good day");
//         return book;
//     }

    
// }




// @RestController  // in rest controller no need to write responsebody anotation
// public class BookController {
//     //first method
//     // @GetMapping("/books")
//     //second method
//     @RequestMapping(value = "/books",method = RequestMethod.GET)
  
//     public String getBooks(){
//         return "this is testing book first";
//     }

    
// }


// @Controller  
// public class BookController {
//     //first method
//     // @GetMapping("/books")
//     //second method
//     @RequestMapping(value = "/books",method = RequestMethod.GET)
//     @ResponseBody
//     public String getBooks(){
//         return "this is testing book first";  //this creates a view
//     }

    
// }
