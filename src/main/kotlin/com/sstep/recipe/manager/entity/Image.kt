package com.sstep.recipe.manager.entity

import jakarta.persistence.Id
import org.bson.types.Binary
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "images")
open class Image {

    @get:Id
    var id: String? = null

    var title: String? = null

    var content: Binary? = null
}