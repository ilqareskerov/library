package com.company.library.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image  extends BaseEntity{
    private String imageUrl;
}
