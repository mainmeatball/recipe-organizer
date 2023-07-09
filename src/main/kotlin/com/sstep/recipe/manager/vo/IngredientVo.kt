package com.sstep.recipe.manager.vo

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.sstep.recipe.manager.enums.UnitOfMeasure

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class IngredientVo @JsonCreator constructor(
    val name: String? = null,
    val unitOfMeasure: UnitOfMeasure? = null,
    val quantity: Double? = null
)