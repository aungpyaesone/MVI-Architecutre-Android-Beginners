package com.aungpyaesone.mvi_architecutre_android_beginners.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aungpyaesone.mvi_architecutre_android_beginners.R
import com.aungpyaesone.mvi_architecutre_android_beginners.data.model.User
import com.aungpyaesone.mvi_architecutre_android_beginners.extension.inflate
import com.aungpyaesone.mvi_architecutre_android_beginners.extension.load
import com.aungpyaesone.mvi_architecutre_android_beginners.viewholder.BaseViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.data_item_view.view.*

class MainAdapter(private val users: ArrayList<User>) : BaseAdapter<BaseViewHolder<User>,User>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<User> {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.data_item_view,parent,false))
    }

}

class DataViewHolder(itemView: View) : BaseViewHolder<User>(itemView){

    init {
        itemView.setOnClickListener {
        }
    }
    override fun bindData(data: User) {
        data?.let {
            itemView.tvName.text = it.name
            itemView.tvEmail.text = it.email
            itemView.imageView.load(data.avatar)
        }

    }
}
