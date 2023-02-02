package com.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mylibrary.R

class BasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        KeyBoardActivity.Builder(this)
    }
}