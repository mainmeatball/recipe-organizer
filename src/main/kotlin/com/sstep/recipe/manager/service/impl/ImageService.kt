package com.sstep.recipe.manager.service.impl

import com.sstep.recipe.manager.dao.ImageRepository
import com.sstep.recipe.manager.entity.Image
import com.sstep.recipe.manager.service.FileService
import org.bson.BsonBinarySubType
import org.bson.types.Binary
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service("imageService")
open class ImageService @Autowired constructor(
    private val imageRepository: ImageRepository,
) : FileService {

    override fun saveFile(fileName: String, file: MultipartFile): String? {
        val image = Image().apply {
            title = fileName
            content = Binary(BsonBinarySubType.BINARY, file.bytes)
        }
        val savedImage = imageRepository.insert(image)
        return savedImage.id
    }

    override fun getFile(id: String): Image {
        return imageRepository.findById(id).orElse(null)
            ?: throw IllegalArgumentException("No image was found in db by id = $id")
    }
}