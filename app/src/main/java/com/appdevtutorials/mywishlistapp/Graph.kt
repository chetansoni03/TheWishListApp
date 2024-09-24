package com.appdevtutorials.mywishlistapp

import android.content.Context
import androidx.room.Room
import com.appdevtutorials.mywishlistapp.data.WishDatabase
import com.appdevtutorials.mywishlistapp.data.WishRepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}