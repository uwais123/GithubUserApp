package com.masuwes.githubuserfirst

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    internal var listUser = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listUser.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataA = listUser.get(position)

        // show name and company on list item
        holder.txt_name.setText(dataA.name)
        holder.txt_company.setText(dataA.company)

        // show picture on list item
        Glide.with(holder.itemView.context)
            .load(listUser.get(position).avatar)
            .into(holder.img_profile)

        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, listUser[position].name, Toast.LENGTH_SHORT).show()
            val moveWithObject = Intent(v.context, DetailActivity::class.java)
            moveWithObject.putExtra("detail", dataA)
            v.context.startActivity(moveWithObject)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_profile: ImageView
        val txt_name: TextView
        val txt_company: TextView

        init {
            img_profile = itemView.findViewById(R.id.img_profile)
            txt_name = itemView.findViewById(R.id.txt_name)
            txt_company = itemView.findViewById(R.id.txt_company)
        }

    }
}