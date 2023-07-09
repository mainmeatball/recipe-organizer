package com.sstep.recipe.manager.dao

import com.sstep.recipe.manager.entity.Image
import org.springframework.data.mongodb.repository.MongoRepository


open interface ImageRepository : MongoRepository<Image, String>