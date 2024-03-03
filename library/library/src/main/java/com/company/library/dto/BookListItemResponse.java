package com.company.library.dto;

import com.company.library.model.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@Builder
@AllArgsConstructor
public class BookListItemResponse {
    private Long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalBookPage;
    private File image;
    private Long categoryId;
}
