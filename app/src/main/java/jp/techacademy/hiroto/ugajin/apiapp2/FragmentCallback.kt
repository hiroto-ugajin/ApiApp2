package jp.techacademy.hiroto.ugajin.apiapp2

class FragmentCallback {
    // お気に入り追加時の処理
    fun onAddFavorite(shop: Shop)

    // お気に入り削除時の処理
    fun onDeleteFavorite(id: String)
}