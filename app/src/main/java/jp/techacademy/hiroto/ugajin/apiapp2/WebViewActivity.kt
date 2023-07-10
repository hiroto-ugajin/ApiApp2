package jp.techacademy.hiroto.ugajin.apiapp2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import jp.techacademy.hiroto.ugajin.apiapp2.FavoriteShop.Companion.findByUrl
import jp.techacademy.hiroto.ugajin.apiapp2.databinding.ActivityWebViewBinding
import jp.techacademy.hiroto.ugajin.apiapp2.FavoriteShop.Companion.isUrlInFavorites

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    private var favoriteShop: FavoriteShop = FavoriteShop()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.webView.loadUrl(intent.getStringExtra(KEY_URL).toString())
        val couponUrls = intent.getStringExtra(KEY_URL).toString()

        binding.webView.webViewClient = MyWebViewClient()

        binding.button1.setOnClickListener() {
            var isFavorite = isUrlInFavorites(couponUrls)
            if (isFavorite) {
                Log.d("my log", "既に、登録済みです")
            } else {
                FavoriteShop.insert(favoriteShop)
                Log.d("my log", "登録ボタンをタップしました")
                isFavorite = !isFavorite

            }
        }

        binding.button2.setOnClickListener() {
            var isFavorite = isUrlInFavorites(couponUrls)
            val foundShop: FavoriteShop? = findByUrl(couponUrls)
            if (isFavorite) {
                FavoriteShop.delete(favoriteShop.id)
//                Log.d("my log", "削除ボタンをタップしました")
//                isFavorite = !isFavorite

            } else {
                Log.d("my log", "元々、お気に入りではありません")
            }
        }
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)

            // ページの読み込み完了時に実行される処理
            val currentUrl = url ?: ""
            val shopId = extractShopIdFromUrl(currentUrl)

            // お気に入りの判定処理を行う
            val isFavorite = FavoriteShop.findBy(shopId) != null

            // ここでisFavoriteを利用して適切な処理を行う
        }
    }

    private fun extractShopIdFromUrl(url: String): String {
        val regex = Regex("""/id(\d+)/""") // URLから"/id数字/"の部分を抽出する正規表現パターン
        val matchResult = regex.find(url)
        return matchResult?.groupValues?.getOrNull(1) ?: ""
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

