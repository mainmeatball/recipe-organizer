package com.sstep.recipe.manager.enums;

public enum RecipeType {
    SOUP("S"),
    SALAD("SL"),
    MAIN("M"),
    BEVERAGE("B");

    private String code;

    private RecipeType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
