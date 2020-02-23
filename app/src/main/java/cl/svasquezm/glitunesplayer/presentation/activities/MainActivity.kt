package cl.svasquezm.glitunesplayer.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cl.svasquezm.glitunesplayer.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
