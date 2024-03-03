package com.company.library.service;

import com.company.library.dto.BookListItemResponse;
import com.company.library.dto.SaveBookRequest;
import com.company.library.model.Book;
import com.company.library.model.Category;
import com.company.library.model.Image;
import com.company.library.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@RequiredArgsConstructor
@Service
public class BookSaveService {
    private final BookRepository bookRepository;

    private final CategoryService categoryService;
    @Transactional
    public BookListItemResponse saveBook(SaveBookRequest saveBookRequest){
        Category category=categoryService.loadCategory(saveBookRequest.getCategoryId());
       final Book book= Book
                .builder()
                .category(category)
                .bookStatus(saveBookRequest.getBookStatus())
                .title(saveBookRequest.getTitle())
                .authorName(saveBookRequest.getAuthorName())
                .lastPageNumber(saveBookRequest.getLastPageNumber())
                .publisher(saveBookRequest.getPublisher())
                .totalBookPage(saveBookRequest.getTotalBookPage())
                .build();
       final  Book fbook= bookRepository.save(book);
      return   BookListItemResponse.builder()
                .categoryId(fbook.getCategory().getId())
                .authorName(fbook.getAuthorName())
                .bookStatus(fbook.getBookStatus())
                .totalBookPage(fbook.getTotalBookPage())
                .lastPageNumber(fbook.getLastPageNumber())
                .publisher(fbook.getPublisher())
                .id(fbook.getId())
                .build();
    }
}
