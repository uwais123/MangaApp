package com.uwaisalqadri.mangaapp.data.souce.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class PosterImage(
    val large: String,
    val medium: String,
    val original: String,
    val small: String,
    val tiny: String
)