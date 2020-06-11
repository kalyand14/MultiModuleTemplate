package com.android.multimoduletemplate.launch

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.android.multimoduletemplate.root.RootActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* Create an Intent that will start the Navigation host activity . */
        Handler().postDelayed(Runnable {
            val mainIntent = Intent(applicationContext, RootActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 2000)
    }
}
