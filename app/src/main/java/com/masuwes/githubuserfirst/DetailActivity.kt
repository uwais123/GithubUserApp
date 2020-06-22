package com.masuwes.githubuserfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var usersData: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar!!.setTitle("User Detail")
        actionBar.setDisplayHomeAsUpEnabled(true)

        usersData = intent.getParcelableExtra("detail")

        detailName.setText(usersData.name)
        detailUserName.setText(usersData.username)
        followers.setText(usersData.followers)
        following.setText(usersData.following)
        repositories.setText(usersData.repository + " Repository")
        detailLocation.setText(usersData.location)
        detailCompany.setText(usersData.company)
        Glide.with(this).load(usersData.avatar).into(detailProfilePict)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}