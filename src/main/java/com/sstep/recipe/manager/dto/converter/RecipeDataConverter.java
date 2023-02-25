package com.sstep.recipe.manager.dto.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sstep.recipe.manager.dto.RecipeData;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RecipeDataConverter implements AttributeConverter<RecipeData, String> {

    final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(final RecipeData recipeData) {
        if (recipeData == null) {
            return null;
        }
        String value = null;
        try {
             value = mapper.writeValueAsString(recipeData);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public RecipeData convertToEntityAttribute(final String serializedData) {
        if (serializedData == null) {
            return null;
        }
        RecipeData recipeData = new RecipeData();
        try {
            recipeData = mapper.readValue(serializedData, RecipeData.class);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }
        return recipeData;
    }
}