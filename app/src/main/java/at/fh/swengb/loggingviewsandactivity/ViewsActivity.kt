package at.fh.swengb.loggingviewsandactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ViewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)
        Log.e("MyViewsActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("MyViewsActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MyViewsActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MyViewsActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MyViewsActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MyViewsActivity", "onDestroy")
    }
}
