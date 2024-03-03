package com.company.library.service;

import com.company.library.dto.BookListItemResponse;
import com.company.library.dto.BookResponse;
import com.company.library.dto.CategoryType;
import com.company.library.model.Book;
import com.company.library.model.BookStatus;
import com.company.library.model.Category;
import com.company.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookListService {
    private final BookRepository bookRepository;
    private CategoryService categoryService;
   public List<BookResponse> listBooks(int size, int page){
       return bookRepository.findAll(PageRequest.of(page,size))
               .getContent()
               .stream()
               .map(BookListService::convertorResponse)
               .collect(Collectors.toList());
   }
   public List<BookResponse> searchBookByCategoryName(CategoryType categoryType){
   Category category= categoryService.findByName(categoryType.getValue());
   return category.getBooks()
           .stream()
           .map(BookListService::convertorResponse)
           .collect(Collectors.toList());
   }
   private static BookResponse convertorResponse(Book model){
       return BookResponse.builder()
               .authorName(model.getAuthorName())
               .title(model.getTitle())
               .imageUrl(model.getImage().getImageUrl()).build();
   }
   public List<BookResponse> searchBookByStatus(BookStatus bookStatus){
   return bookRepository.findByBookStatus(bookStatus).stream().map(model->BookResponse.builder()
           .id(model.getId())
           .imageUrl(model.getImage().getImageUrl())
           .build()).collect(Collectors.toList());
   }
   public List<BookResponse> searchBookByTitle(String title){
       System.out.println(title);
       return bookRepository.findByTitle(title).stream().map(model-> BookResponse.builder()
               .id(model.getId())
               .imageUrl(model.getImage().getImageUrl())
               .build()).collect(Collectors.toList());
   }
   public List<BookResponse> getAllBooks(){
       return bookRepository.findAll().stream().map(model->BookResponse.builder()
               .id(model.getId())
               .title(model.getTitle())
               .totalBookPage(model.getTotalBookPage())
               .authorName(model.getAuthorName())
               .publisher(model.getPublisher())
               .bookStatus(model.getBookStatus())
               .build()).collect(Collectors.toList());

   }
}
