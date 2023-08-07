package uz.abboskhan.wallpaper

import android.app.WallpaperManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)


        val imgView = findViewById<ImageView>(R.id.imageView)
        val btn = findViewById<Button>(R.id.button)

        val imgIntent = intent.getIntExtra("IMG", 0)
        imgView.setImageResource(imgIntent)

        val wallpaperManager = WallpaperManager.getInstance(applicationContext)
        btn.setOnClickListener {
            try {
                wallpaperManager.setResource(imgIntent)
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}