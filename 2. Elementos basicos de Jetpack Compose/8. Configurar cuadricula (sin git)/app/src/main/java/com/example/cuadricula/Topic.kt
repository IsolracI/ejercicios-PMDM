package com.example.cuadricula

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Topic(
    @StringRes val topicNameID: Int,
    val amountOfCourses: Int,
    @DrawableRes val topicImageID: Int
)