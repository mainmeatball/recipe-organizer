package com.sstep.recipe.manager.controller

import com.sstep.recipe.manager.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
open class ImageController @Autowired constructor(
    @Qualifier("imageService") private val imageService: FileService
) {

    @GetMapping(value = ["/image"])
    open fun getImage(@RequestParam("id") id: String): String? {
        return imageService.getFile(id).content?.data?.toBase64()
    }

    private fun ByteArray.toBase64(): String =
        String(Base64.getEncoder().encode(this))

    @PostMapping("/uploadImages")
    open fun uploadImages(@RequestParam file: MultipartFile): String? {
        validate(file)
        return imageService.saveFile(file.name, file)
    }

    private fun validate(file: MultipartFile) {
        val contentType = requireNotNull(file.contentType) { "File content type is null" }
        if (!contentType.isImage()) {
            throw IllegalArgumentException("Only images could be uploaded to server")
        }
    }

    private fun String.isImage() = split("/").firstOrNull() == "image"
}