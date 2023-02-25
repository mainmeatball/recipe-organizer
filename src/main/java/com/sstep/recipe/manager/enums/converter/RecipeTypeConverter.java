package com.sstep.recipe.manager.enums.converter;

import com.sstep.recipe.manager.enums.RecipeType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;


@Converter(autoApply = true)
public class RecipeTypeConverter implements AttributeConverter<RecipeType, String> {

    @Override
    public String convertToDatabaseColumn(final RecipeType category) {
        if (category == null) {
            return null;
        }
        return category.getCode();
    }

    @Override
    public RecipeType convertToEntityAttribute(final String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(RecipeType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}