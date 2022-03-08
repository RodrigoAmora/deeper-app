package br.com.deeper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.deeper.ui.home.HomeFragment
import br.com.deeper.util.FragmentUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentUtil.changeFragment(R.id.nav_host_fragment, HomeFragment(), getSupportFragmentManager(), false, null)
    }
}