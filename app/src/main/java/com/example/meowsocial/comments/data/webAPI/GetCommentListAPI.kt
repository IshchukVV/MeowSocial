package com.example.meowsocial.comments.data.webAPI

import com.example.meowsocial.comments.data.models.CommentListModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GetCommentListAPI {

    @GET("/Comment/get")
    suspend fun getCommentList(
        @Query("PostId") PostId: String,
//        @Query("Offset") Offset: Int,  //нужно в будущем для пагинации
//        @Query("Limit") Limit: Int,    //нужно в будущем для пагинации
    ): CommentListModel
}