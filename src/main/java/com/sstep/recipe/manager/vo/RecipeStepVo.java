package com.sstep.recipe.manager.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class RecipeStepVo {

    private String text;
    private Integer order;

    @JsonCreator
    public RecipeStepVo(
            @JsonProperty("text") final String text,
            @JsonProperty("order") final Integer order) {
        this.text = text;
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public Integer getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "RecipeStepVo{" +
                "text='" + text + '\'' +
                ", order=" + order +
                '}';
    }
}
