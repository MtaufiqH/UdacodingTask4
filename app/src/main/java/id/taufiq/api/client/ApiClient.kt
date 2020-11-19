package id.taufiq.api.client

import id.taufiq.api.response.ApiResponse
import id.taufiq.api.response.MyVisitor
import retrofit2.Response
import retrofit2.http.*

/**
 * Created By Taufiq on 11/18/2020.
 *
 */
interface ApiClient {


    @GET("getAll.php")
    suspend fun getAllVisitor(): Response<MyVisitor>

    @FormUrlEncoded
    @POST("insert.php")
    suspend fun insertVisitor(
        @Field("nama") nama: String,
        @Field("no_hp") noHp: String,
        @Field("tanggal_kunjungan") tglKunjungan: String,
        @Field("alamat") alamat: String,
        @Field("asal_sekolah") sekolahAsal: String,
        @Field("tujuan") tujuanKunjungan: String
    ): Response<ApiResponse>


    @FormUrlEncoded
    @POST("update.php")
    suspend fun updateVisitor(
        @Field("id") visitorId: String,
        @Field("nama") nama: String,
        @Field("no_hp") noHp: String,
        @Field("tanggal_kunjungan") tglKunjungan: String,
        @Field("alamat") alamat: String,
        @Field("asal_sekolah") sekolahAsal: String,
        @Field("tujuan") tujuanKunjungan: String
    ): Response<ApiResponse>


    @FormUrlEncoded
    @POST("delete.php")
    suspend fun deleteVisitor(
        @Field("id") visitorId: String): Response<ApiResponse>


}