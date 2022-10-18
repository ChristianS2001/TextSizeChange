package edu.temple.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), SizeFragment {


    lateinit var textFragment: TextFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Create and attach fragments if not already exist
        if (savedInstanceState == null) {
            textFragment = TextFragment()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_1, SizeFragment())
                .add(R.id.container_2, textFragment)
                .commit()
        } else {
            // Grab reference to previously added fragment
            textFragment = supportFragmentManager.findFragmentById(R.id.container_2) as TextFragment
        }

    }

    //instead of using this interface we take what data we get from a viewmodel created and use that to make changes instead
    override fun onChange(value: Int) {
        // Change text size
        textFragment.changeTextSize(value.toFloat())
    }

}