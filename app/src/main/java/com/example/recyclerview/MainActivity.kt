package com.example.recyclerview

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.MyAdapter
import com.example.recyclerview.model.User


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val layoutManager = LinearLayoutManager(this)

        //for Grid layout
        //val layoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager

        val userDataList = Dummydata()
        val adapter = MyAdapter(this,userDataList)
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun Dummydata(): List<User> {

        val userList = mutableListOf<User>()
        userList.add(User("Sid", R.drawable.image1, "35732657265"))
        userList.add(User("Diego", R.drawable.image2, "457326865747"))
        userList.add(User("Buck", R.drawable.image3, "557326498456"))
        userList.add(User("Scrat", R.drawable.image4, "657326545635"))
        userList.add(User("Manny", R.drawable.image5, "7573345265"))
        userList.add(User("Crash and Eddie", R.drawable.image6, "87696757265"))
        userList.add(User("Scratte", R.drawable.image7, "9123527265"))
        userList.add(User("Ellie", R.drawable.image8, "0255345357265"))
        userList.add(User("Shira", R.drawable.image9, "26856857265"))
        userList.add(User("Roshan", R.drawable.image10, "4232547265"))

        return userList

    }
}


