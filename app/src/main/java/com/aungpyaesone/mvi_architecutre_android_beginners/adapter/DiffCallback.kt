package com.aungpyaesone.mvi_architecutre_android_beginners.adapter

import androidx.recyclerview.widget.DiffUtil
import com.aungpyaesone.mvi_architecutre_android_beginners.data.model.User

class DiffCallback(private val oldList:List<User>,private val newList: List<User>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_,name,avatar) = oldList[oldItemPosition]
        val (_,name2,avatar2) = newList[newItemPosition]
        return name == name2 && avatar == avatar2
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}