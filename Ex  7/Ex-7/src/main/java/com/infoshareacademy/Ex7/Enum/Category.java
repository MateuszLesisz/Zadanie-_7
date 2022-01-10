package com.infoshareacademy.Ex7.Enum;

public enum Category {
    GARDEN("Ogród"),
    HOME("Dom"),
    WORK("Praca"),
    OFFICE("Biuro"),
    SCHOOL("Szkoła");


    private final String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category.toString();
    }
}
