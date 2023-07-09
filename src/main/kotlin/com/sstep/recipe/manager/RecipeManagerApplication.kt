package com.sstep.recipe.manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class RecipeManagerApplication

fun main(args: Array<String>) {
    runApplication<RecipeManagerApplication>(*args)
}