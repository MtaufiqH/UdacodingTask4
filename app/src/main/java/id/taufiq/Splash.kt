package id.taufiq

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.helper.delayFunction
import id.taufiq.view.MainActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        delayFunction({ moveIntent() }, 3000)

    }

    private fun moveIntent() {
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
    }
}