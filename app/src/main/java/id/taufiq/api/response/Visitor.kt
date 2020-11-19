package id.taufiq.api.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Visitor(
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("asal_sekolah")
    val asalSekolah: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("no_hp")
    val noHp: String,
    @SerializedName("tanggal_kunjungan")
    val tanggalKunjungan: String,
    @SerializedName("tujuan")
    val tujuan: String
) : Parcelable