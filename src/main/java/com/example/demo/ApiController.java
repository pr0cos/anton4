package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class ApiController {

    List<Book> books = new ArrayList<>();

    @PostMapping("book") //curl -X POST -H "Content-Type: text/plain" -d "Война и Мир" localhost:8080/book
    public ResponseEntity<Void> addBook(@RequestBody String book){
        books.add(new Book(book));
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("book/{index}") //curl -X DELETE localhost:8080/book/0
    public ResponseEntity<Void> deleteBook(@PathVariable("index") Integer id){
        books.remove((int) id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("book") //curl -X GET localhost:8080/book
    public ResponseEntity<List<String>> getBooks(){
        List<String> ans = new ArrayList<>();
        for(Book book : books){
            ans.add(book.getName());
        }
        return ResponseEntity.ok(ans);
    }

    @GetMapping("book/{index}") //curl -X GET localhost:8080/book/0
    public ResponseEntity<String> getBook(@PathVariable("index") Integer id){
        return ResponseEntity.ok(books.get(id).getName());
    }

    @PutMapping("book/{index}") //curl -X PUT -H "Content-Type: text/plain" -d "Обломов" localhost:8080/book/0
    public ResponseEntity<Void> changeBook(@PathVariable("index") Integer id, @RequestBody String name){
        books.get(id).setName(name);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("book") //curl -X DELETE localhost:8080/book
    public ResponseEntity<Void> deleteBooks(){
        books.clear();
        return ResponseEntity.accepted().build();
    }

    @PostMapping("book/{index}/review") //curl -X POST -H "Content-Type: text/plain" -d "Хорошая книга!" localhost:8080/book/0/review
    public ResponseEntity<Void> newReview(@PathVariable("index") Integer id, @RequestBody String review){
        books.get(id).newReview(review);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("book/{index1}/review/{index2}") //curl -X DELETE localhost:8080/book/0/review/0
    public ResponseEntity<Void> deleteReview(@PathVariable("index1") Integer id1, @PathVariable("index2") Integer id2){
        books.get(id1).deleteReview(id2);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("book/{index1}/review/{index2}") //curl -X PUT -H "Content-Type: text/plain" -d "Очень хорошая книга!" localhost:8080/book/0/review/0
    public ResponseEntity<Void> changeReview(@PathVariable("index1") Integer id1, @PathVariable("index2") Integer id2, @RequestBody String review){
        books.get(id1).changeReview(id2, review);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("book/{index}/review") //curl -X GET localhost:8080/book/0/review
    public ResponseEntity<List<String>> getReviews(@PathVariable("index") Integer id){
        return ResponseEntity.ok(books.get(id).getReview());
    }
}