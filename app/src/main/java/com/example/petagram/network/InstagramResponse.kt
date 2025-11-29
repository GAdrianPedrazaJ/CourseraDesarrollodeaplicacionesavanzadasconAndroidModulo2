package com.example.petagram.network

data class InstagramResponse(
    val data: List<MediaItem>?
)

data class MediaItem(
    val id: String?,
    val caption: String?
)