package com.example.meowsocial.comments.data

import java.security.Timestamp
import java.util.*



data class Comment(
    var uid: String = "",
    var username: String = "",
    var photo: String? = null,
    var text: String = "",
    var timestamp: String = "",
    var postCommentId: String = ""
) {
    fun timestampDate() = Date(timestamp as Long)

    fun addOnFailureListener(onFailureListener: Any) {
        TODO("Not yet implemented")
    }
}