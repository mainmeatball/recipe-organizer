package com.sstep.recipe.manager.service

import com.sstep.recipe.manager.entity.Image
import org.springframework.web.multipart.MultipartFile

interface FileService {

    fun saveFile(fileName: String, file: MultipartFile): String?

    fun getFile(id: String): Image
}