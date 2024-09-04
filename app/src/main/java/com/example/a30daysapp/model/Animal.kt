package com.example.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.example.a30daysapp.R

data class Animal(
    @StringRes val nameId: Int ,
    @StringRes val description: Int,
    @DrawableRes val imageId: Int,
    var day: String = "Day ",
)

object GetAnimals {
    fun get(): List<Animal> {
        val animals = listOf(
            Animal(nameId = R.string.giraffe, description = R.string.giraffe_desc, imageId = R.drawable.giraffe),
            Animal(nameId = R.string.cat, description = R.string.cat_desc, imageId = R.drawable.cat),
            Animal(nameId = R.string.chameleon, description = R.string.chameleon_desc, imageId = R.drawable.chameleon),
            Animal(nameId = R.string.puppies, description = R.string.puppies_desc, imageId = R.drawable.puppies),
            Animal(nameId = R.string.bunny, description = R.string.bunny_desc, imageId = R.drawable.bunny),
            Animal(nameId = R.string.deer, description = R.string.deer_desc, imageId = R.drawable.deer),
            Animal(nameId = R.string.duckling, description = R.string.duckling_desc, imageId = R.drawable.duckling),
            Animal(nameId = R.string.parrot, description = R.string.parrot_desc, imageId = R.drawable.parrot),
            Animal(nameId = R.string.penguin, description = R.string.penguin_desc, imageId = R.drawable.penguin),
            Animal(nameId = R.string.squirrel, description = R.string.squirrel_desc, imageId = R.drawable.squirrel),
            Animal(nameId = R.string.tiger, description = R.string.tiger_desc, imageId = R.drawable.tiger),
            Animal(nameId = R.string.giraffe, description = R.string.giraffe_desc, imageId = R.drawable.giraffe),
            Animal(nameId = R.string.cat, description = R.string.cat_desc, imageId = R.drawable.cat),
            Animal(nameId = R.string.chameleon, description = R.string.chameleon_desc, imageId = R.drawable.chameleon),
            Animal(nameId = R.string.puppies, description = R.string.puppies_desc, imageId = R.drawable.puppies),
            Animal(nameId = R.string.bunny, description = R.string.bunny_desc, imageId = R.drawable.bunny),
            Animal(nameId = R.string.deer, description = R.string.deer_desc, imageId = R.drawable.deer),
            Animal(nameId = R.string.duckling, description = R.string.duckling_desc, imageId = R.drawable.duckling),
            Animal(nameId = R.string.parrot, description = R.string.parrot_desc, imageId = R.drawable.parrot),
            Animal(nameId = R.string.penguin, description = R.string.penguin_desc, imageId = R.drawable.penguin),
            Animal(nameId = R.string.squirrel, description = R.string.squirrel_desc, imageId = R.drawable.squirrel),
            Animal(nameId = R.string.tiger, description = R.string.tiger_desc, imageId = R.drawable.tiger),
            Animal(nameId = R.string.giraffe, description = R.string.giraffe_desc, imageId = R.drawable.giraffe),
            Animal(nameId = R.string.cat, description = R.string.cat_desc, imageId = R.drawable.cat),
            Animal(nameId = R.string.chameleon, description = R.string.chameleon_desc, imageId = R.drawable.chameleon),
            Animal(nameId = R.string.puppies, description = R.string.puppies_desc, imageId = R.drawable.puppies),
            Animal(nameId = R.string.bunny, description = R.string.bunny_desc, imageId = R.drawable.bunny),
            Animal(nameId = R.string.deer, description = R.string.deer_desc, imageId = R.drawable.deer),
            Animal(nameId = R.string.duckling, description = R.string.duckling_desc, imageId = R.drawable.duckling),
            Animal(nameId = R.string.parrot, description = R.string.parrot_desc, imageId = R.drawable.parrot),
            Animal(nameId = R.string.penguin, description = R.string.penguin_desc, imageId = R.drawable.penguin),
            Animal(nameId = R.string.squirrel, description = R.string.squirrel_desc, imageId = R.drawable.squirrel),
            Animal(nameId = R.string.tiger, description = R.string.tiger_desc, imageId = R.drawable.tiger),
        )

        animals.forEachIndexed { index, animal ->
            animal.day = animal.day + (index + 1).toString()
        }

        return animals
    }

}
