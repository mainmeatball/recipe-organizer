package com.sstep.recipe.manager.enums.converter

import com.sstep.recipe.manager.enums.RecipeType
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.util.stream.Stream

@Converter(autoApply = true)
class RecipeTypeConverter : AttributeConverter<RecipeType?, String?> {

    override fun convertToDatabaseColumn(category: RecipeType?): String? {
        return category?.code
    }

    override fun convertToEntityAttribute(code: String?): RecipeType? {
        code ?: return null
        return RecipeType.values().first { it.code == code }
    }
}