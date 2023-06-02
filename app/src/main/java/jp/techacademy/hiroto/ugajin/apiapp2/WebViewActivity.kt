package jp.techacademy.hiroto.ugajin.apiapp2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import jp.techacademy.hiroto.ugajin.apiapp2.databinding.ActivityWebViewBinding
import android.widget.Toast

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_web_view)
        setContentView(binding.root)

        binding.webView.loadUrl(intent.getStringExtra(KEY_URL).toString())
        binding.button1.setOnClickListener()
    }

    companion object {
        private const val KEY_URL = "key_url"
        fun start(activity: Activity, url: String) {
            activity.startActivity(
                Intent(activity, WebViewActivity::class.java).putExtra(
                    KEY_URL,
                    url
                )
            )
        }
    }
}

private fun Button.setOnClickListener() {
    val isFavorite = FavoriteShop.findBy(id) != null

    if (isFavorite) {
        Toast.makeText(this, R.string.registered_favorite, Toast.LENGTH_SHORT)
            .show()
    } else {
        Log.d("mylog", "登録ボタンをタップしました")
    }
}
