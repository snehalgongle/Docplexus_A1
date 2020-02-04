package com.snake.docplexus_a1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class MyAdapter(
    internal var context: Context,
    internal var dataList: ArrayList<Data>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // inflate the Layout with the UI that we have created for the RecyclerView
        val v = LayoutInflater.from(parent.context).inflate(R.layout.single_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data: Data = dataList.get(position)
        holder.userName.text = data.user?.userName
        Glide.with(context)
            .load(data.user?.userImage)
            .apply(RequestOptions.circleCropTransform()
                .placeholder(R.drawable.ic_account_circle_black_24dp))
            .into(holder.userImage)
//        holder.time.text=data.createdAt
        holder.title.text = data.title
        Glide.with(context)
            .load(data.image)
            .into(holder.image)
        holder.desc.text=data.body


        holder.view.text = data.view.toString()+" Views"
        holder.vote.text = data.vote.toString()+" Votes"
        holder.comment.text=data.comment.toString()+" Comments"
    }


    override fun getItemCount(): Int {
        //return the item count
        return dataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //connecting od with the text views
        internal var userName: TextView = itemView.findViewById(R.id.userName) as TextView
        internal var userImage: ImageView=itemView.findViewById(R.id.userImage) as ImageView
//        internal var time: TextView=itemView.findViewById(R.id.time) as TextView
        internal var title: TextView = itemView.findViewById(R.id.title) as TextView
        internal var image:ImageView =itemView.findViewById(R.id.image) as ImageView
        internal var desc: TextView = itemView.findViewById(R.id.desc) as TextView
        internal var view: TextView =itemView.findViewById(R.id.view)as TextView
        internal var vote: TextView= itemView.findViewById(R.id.vote)as TextView
        internal var comment: TextView=itemView.findViewById(R.id.comment)as TextView
    }
}