package com.example.meowsocial.home.data.webAPI

import com.example.meowsocial.home.data.models.PostListModel
import retrofit2.http.GET


interface GetPostListAPI {
    @GET("/Post/get-by-followings")
    suspend fun getPostsList(
//        @Query("Offset") Offset: Int,  //нужно в будущем для пагинации
//        @Query("Limit") Limit: Int,    //нужно в будущем для пагинации
    ): PostListModel
}