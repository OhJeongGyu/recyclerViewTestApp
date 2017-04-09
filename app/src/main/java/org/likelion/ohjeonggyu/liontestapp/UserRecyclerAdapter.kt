package org.likelion.ohjeonggyu.liontestapp

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.likelion.ohjeonggyu.liontestapp.UserRecyclerAdapter.UserHolder
import java.util.zip.Inflater

/**
 * Created by ohjeonggyu on 2017. 4. 1..
 */
class UserRecyclerAdapter(private var context: Context) : RecyclerView.Adapter<UserHolder>() {


    private var itemList: MutableList<UserModel.User> = ArrayList()

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.holder, parent, false)
        return UserHolder(view)

    }

    override fun onBindViewHolder(holder: UserHolder?, position: Int) {
        val user = itemList[position]
        holder?.apply {
            Glide.with(context)
                    .load(user.image) //url
                    .centerCrop()
                    .into(holder.imageView)
            nameTextView.text = user.name
            phoneNumberTextView.text = user.address
            ageTextView.text = user.age.toString()
        }
    }

    fun addUsers(list: List<UserModel.User>) {
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val imageView: ImageView by lazy {
            itemView.findViewById(R.id.imageView) as ImageView
        }

        internal val nameTextView: TextView by lazy {
            itemView.findViewById(R.id.nameTextView) as TextView
        }

        internal val phoneNumberTextView: TextView by lazy {
            itemView.findViewById(R.id.phoneNumberTextView) as TextView
        }

        internal val ageTextView: TextView by lazy {
            itemView.findViewById(R.id.ageTextView) as TextView
        }


    }

}