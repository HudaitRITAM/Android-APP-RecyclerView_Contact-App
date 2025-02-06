package com.example.recyclerview.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.contactActivity
import com.example.recyclerview.model.User

class MyAdapter(private val context: Context, private val userData: List<User>): RecyclerView.Adapter<MyAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ListViewHolder {

       return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyAdapter.ListViewHolder, position: Int) {
        holder.bind(userData[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(context,contactActivity::class.java)
            intent.putExtra("name",userData[position].userName)
            intent.putExtra("profile",userData[position].userProfile)
            intent.putExtra("contact",userData[position].userContact)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int =userData.size

    class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(user: User) {
            val profileImage = itemView.findViewById<ImageView>(R.id.contact_img)
            val name = itemView.findViewById<TextView>(R.id.name)
            val contact = itemView.findViewById<TextView>(R.id.phone)

            profileImage.setImageResource(user.userProfile)
            name.text = user.userName
            contact.text = user.userContact
        }

    }
}