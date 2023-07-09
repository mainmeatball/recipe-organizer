package com.sstep.recipe.manager.dto.converter

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import com.sstep.recipe.manager.dto.RecipeData
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class RecipeDataConverter : AttributeConverter<RecipeData?, String?> {

    override fun convertToDatabaseColumn(recipeData: RecipeData?): String? {
        recipeData ?: return null
        var value: String? = null
        try {
            value = mapper.writeValueAsString(recipeData)
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
        }
        return value
    }

    override fun convertToEntityAttribute(serializedData: String?): RecipeData? {
        serializedData ?: return null
        var recipeData: RecipeData? = null
        try {
            recipeData = mapper.readValue(serializedData, RecipeData::class.java)
        } catch (e: JsonProcessingException) {
            e.printStackTrace()
        }
        return recipeData
    }

    private companion object {
        private val mapper = ObjectMapper().apply {
            registerModule(ParameterNamesModule())
        }
    }
}