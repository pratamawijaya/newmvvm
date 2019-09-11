package newmvvm.feature.opendota

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import newmvvm.feature.opendota.di.injectFeature

class OpenDotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_dota)

        injectFeature()
    }
}
