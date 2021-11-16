package com.avanade.popfunko.model

import androidx.annotation.DrawableRes

data class Funko(val code: Int, val name: String, @DrawableRes val imageResourceId: Int, val collection: String)