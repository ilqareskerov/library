package com.company.library.controller;

import com.company.library.dto.BookListItemResponse;
import com.company.library.dto.BookResponse;
import com.company.library.dto.CategoryType;
import com.company.library.dto.SaveBookRequest;
import com.company.library.service.BookListService;
import com.company.library.service.BookSaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookRestController {
    @Autowired
    private  final BookListService bookListService;
    @Autowired
    private final BookSaveService bookSaveService;
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok(bookListService.getAllBooks());
    }
    @PostMapping("/save")
    public ResponseEntity<BookListItemResponse> saveBook(@Valid @RequestBody  SaveBookRequest saveBookRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookSaveService.saveBook(saveBookRequest));
    }
    @GetMapping("/list")
    public ResponseEntity<List<BookResponse>> listBook(@RequestParam(name = "size") int size, @RequestParam(name = "page") int page){
        return ResponseEntity.ok(bookListService.listBooks(size,page));
    }
    @GetMapping("/list/{categoryType}")
    public ResponseEntity<List<BookResponse>> searchBookByCategoryName(@PathVariable(name = "categoryType") CategoryType categoryType){
      return ResponseEntity.ok(bookListService.searchBookByCategoryName(categoryType));
    }

    @GetMapping("/list/{title}")
    public ResponseEntity<List<BookResponse>> searchBookByTitle(@PathVariable(name = "title") String title) {
        return ResponseEntity.ok(bookListService.searchBookByTitle(title));
    }

}
