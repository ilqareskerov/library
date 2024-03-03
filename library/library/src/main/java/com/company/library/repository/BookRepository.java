package com.company.library.repository;

import com.company.library.model.Book;
import com.company.library.model.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> , JpaSpecificationExecutor<Book> {
    List<Book> findByBookStatus(BookStatus bookStatus);
    List<Book> findByTitle(String title);
}
