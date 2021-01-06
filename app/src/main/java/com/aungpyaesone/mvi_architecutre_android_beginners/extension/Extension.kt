package com.aungpyaesone.mvi_architecutre_android_beginners.extension

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(uri: String){
    Glide.with(context)
        .load(uri)
        .into(this)
}

fun ViewGroup.inflate(layoutRes:Int) =  LayoutInflater.from(context).inflate(layoutRes,this,false)