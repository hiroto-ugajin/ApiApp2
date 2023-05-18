package jp.techacademy.hiroto.ugajin.apiapp2
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class ApiResponse(
    @Json(name = "results")
    val results: Results
)

@JsonClass(generateAdapter = true)
data class Results(
    @Json(name = "api_version")
    val apiVersion: String,
    @Json(name = "results_available")
    val resultsAvailable: Int,
    @Json(name = "results_returned")
    val resultsReturned: String,
    @Json(name = "results_start")
    val resultsStart: Int,
    @Json(name = "shop")
    val shop: List<Shop>
)

@JsonClass(generateAdapter = true)
data class Shop(
    @Json(name = "access")
    val access: String,
    @Json(name = "address")
    val address: String,
    @Json(name = "band")
    val band: String,
    @Json(name = "barrier_free")
    val barrierFree: String,
    @Json(name = "budget")
    val budget: Budget,
    @Json(name = "budget_memo")
    val budgetMemo: String,
    @Json(name = "capacity")
    val capacity: Int,
    @Json(name = "card")
    val card: String,
    @Json(name = "catch")
    val `catch`: String,
    @Json(name = "charter")
    val charter: String,
    @Json(name = "child")
    val child: String,
    @Json(name = "close")
    val close: String,
    @Json(name = "coupon_urls")
    val couponUrls: CouponUrls,
    @Json(name = "course")
    val course: String,
    @Json(name = "english")
    val english: String,
    @Json(name = "free_drink")
    val freeDrink: String,
    @Json(name = "free_food")
    val freeFood: String,
    @Json(name = "genre")
    val genre: Genre,
    @Json(name = "horigotatsu")
    val horigotatsu: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "karaoke")
    val karaoke: String,
    @Json(name = "ktai_coupon")
    val ktaiCoupon: Int,
    @Json(name = "large_area")
    val largeArea: LargeArea,
    @Json(name = "large_service_area")
    val largeServiceArea: LargeServiceArea,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lng")
    val lng: Double,
    @Json(name = "logo_image")
    val logoImage: String,
    @Json(name = "lunch")
    val lunch: String,
    @Json(name = "middle_area")
    val middleArea: MiddleArea,
    @Json(name = "midnight")
    val midnight: String,
    @Json(name = "mobile_access")
    val mobileAccess: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "name_kana")
    val nameKana: String,
    @Json(name = "non_smoking")
    val nonSmoking: String,
    @Json(name = "open")
    val `open`: String,
    @Json(name = "other_memo")
    val otherMemo: String,
    @Json(name = "parking")
    val parking: String,
    @Json(name = "party_capacity")
    val partyCapacity: Int,
    @Json(name = "pet")
    val pet: String,
    @Json(name = "photo")
    val photo: Photo,
    @Json(name = "private_room")
    val privateRoom: String,
    @Json(name = "service_area")
    val serviceArea: ServiceArea,
    @Json(name = "shop_detail_memo")
    val shopDetailMemo: String,
    @Json(name = "show")
    val show: String,
    @Json(name = "small_area")
    val smallArea: SmallArea,
    @Json(name = "station_name")
    val stationName: String,
    @Json(name = "sub_genre")
    val subGenre: SubGenre,
    @Json(name = "tatami")
    val tatami: String,
    @Json(name = "tv")
    val tv: String,
    @Json(name = "urls")
    val urls: Urls,
    @Json(name = "wedding")
    val wedding: String,
    @Json(name = "wifi")
    val wifi: String
)

@JsonClass(generateAdapter = true)
data class Budget(
    @Json(name = "average")
    val average: String,
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class CouponUrls(
    @Json(name = "pc")
    val pc: String,
    @Json(name = "sp")
    val sp: String
)

@JsonClass(generateAdapter = true)
data class Genre(
    @Json(name = "catch")
    val `catch`: String,
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class LargeArea(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class LargeServiceArea(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class MiddleArea(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class Photo(
    @Json(name = "mobile")
    val mobile: Mobile,
    @Json(name = "pc")
    val pc: Pc
)

@JsonClass(generateAdapter = true)
data class ServiceArea(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class SmallArea(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class SubGenre(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class Urls(
    @Json(name = "pc")
    val pc: String
)

@JsonClass(generateAdapter = true)
data class Mobile(
    @Json(name = "l")
    val l: String,
    @Json(name = "s")
    val s: String
)

@JsonClass(generateAdapter = true)
data class Pc(
    @Json(name = "l")
    val l: String,
    @Json(name = "m")
    val m: String,
    @Json(name = "s")
    val s: String
)