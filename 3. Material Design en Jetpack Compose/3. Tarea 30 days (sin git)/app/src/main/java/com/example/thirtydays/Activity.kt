package com.example.thirtydays

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Activity(
    @StringRes val dayNumer: Int,
    @StringRes val activityTitle: Int,
    @DrawableRes val activityImage: Int,
    @StringRes val activityDescription: Int
)