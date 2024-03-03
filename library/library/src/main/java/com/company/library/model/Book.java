package com.company.library.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Book extends BaseEntity {

    private String title;
    private String authorName;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalBookPage;
    @OneToOne
    private Image image;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;
    private Long userId;

}
