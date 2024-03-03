package com.company.library.dto;

import lombok.Getter;

@Getter
public enum CategoryType {
    RE_SEARCH_HISTORY("Tarix"),
    SCIENCE("Elm"),
    COMIC("Cizgi Roman"),
    CHILD_AND_YOUTH("Usaq ve Genc"),
    LESSON_TEST_BOOK("Ders Kitabi"),
    RELIGION("Din"),
    LITERATURE("Edebiyyat"),
    EDUCATION_REFERENCE("Tehsil "),
    PHILOSOPH("Felsefe"),
    FOREIGN_LANGUAGES("Xarici Dil"),
    HOBBY("Hobi"),
    MYTH_LEGEND("Mitologi Efsane"),
    HUMOR("Humor"),
    PRESTIGE_BOOKS("Prestif Kitablari"),
    ART_DESIGN("Senet"),
    AUDIO_BOOKS("Sesli Kitab"),
    OTHER("Basqalari");
    private final String value;
    CategoryType(String value) {
    this.value=value;
    }
}
