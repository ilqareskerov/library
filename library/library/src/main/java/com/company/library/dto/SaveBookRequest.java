package com.company.library.dto;
import com.company.library.model.Book;
import com.company.library.model.BookStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.io.File;

@Data
public final class SaveBookRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String authorName;
    @NotNull
    private BookStatus bookStatus;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer lastPageNumber;
    @NotNull
    private Integer totalBookPage;
    @JsonIgnore
    private File image;
    @NotNull
    private Long categoryId;
}
