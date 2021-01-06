package com.aungpyaesone.mvi_architecutre_android_beginners.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView){

    abstract fun bindData(data: T)
}