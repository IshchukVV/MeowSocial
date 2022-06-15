package com.example.meowsocial.ui.post

import com.example.meowsocial.home.data.Post


interface PostItemUserActionsListener {
    fun onPostClicked(post: Post)
}