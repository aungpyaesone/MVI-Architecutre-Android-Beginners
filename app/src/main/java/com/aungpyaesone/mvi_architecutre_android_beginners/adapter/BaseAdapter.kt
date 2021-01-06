package com.aungpyaesone.mvi_architecutre_android_beginners.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aungpyaesone.mvi_architecutre_android_beginners.data.model.User
import com.aungpyaesone.mvi_architecutre_android_beginners.viewholder.BaseViewHolder

abstract class BaseAdapter<T:BaseViewHolder<W>,W> : RecyclerView.Adapter<BaseViewHolder<W>>() {
    protected var mDataList: MutableList<W> = mutableListOf()

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<W>, position: Int) {
        holder.bindData(mDataList[position])
    }

    fun setData(data:List<W>){
        val diffCallback = DiffCallback(data as List<User>, data as List<User>)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        mDataList.clear()
        mDataList.addAll(data)
        diffResult.dispatchUpdatesTo(this)
    }
}