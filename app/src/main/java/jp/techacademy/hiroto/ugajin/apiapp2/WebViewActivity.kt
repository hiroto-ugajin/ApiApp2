package jp.techacademy.hiroto.ugajin.apiapp2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.hiroto.ugajin.apiapp2.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    private var favoriteShop: FavoriteShop = FavoriteShop() // 課題:クーポン詳細ページでもお気に入りの追加削除
    private var isFavorite = false // 課題:クーポン詳細ページでもお気に入りの追加削除

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.webView.loadUrl(intent.getStringExtra(KEY_URL).toString())
        // 課題:クーポン詳細ページでもお気に入りの追加削除
        // API Level33で非推奨だがAPI24以降から対応するため使用
        @Suppress("DEPRECATION")
        favoriteShop =
            intent.getSerializableExtra(KEY_FAVORITE_SHOP) as? FavoriteShop ?: return { finish() }()
        binding.webView.loadUrl(favoriteShop.url)

        // お気に入り状態を取得
        isFavorite = FavoriteShop.findBy(favoriteShop.id) != null

        // 星の処理
        binding.favoriteImageView.apply {
            // 白抜きの星を設定
            setImageResource(if (isFavorite) R.drawable.ic_star else R.drawable.ic_star_border)

            // 星をタップ（クリック）した時の処理
            setOnClickListener {
                isFavorite = !isFavorite
                // タップ後の状態を反映
                setImageResource(if (isFavorite) R.drawable.ic_star else R.drawable.ic_star_border)
                if (isFavorite)
                    FavoriteShop.insert(favoriteShop)
                else
                    FavoriteShop.delete(favoriteShop.id)
            }
        }
    }


    companion object {
        private const val KEY_FAVORITE_SHOP = "key_favorite_shop" // 課題:クーポン詳細ページでもお気に入りの追加削除

        // 課題:クーポン詳細ページでもお気に入りの追加削除
        fun start(activity: Activity, favoriteShop: FavoriteShop) {
            activity.startActivity(
                Intent(activity, WebViewActivity::class.java).putExtra(
                    KEY_FAVORITE_SHOP,
                    favoriteShop
                )
            )
        }
    }
}

