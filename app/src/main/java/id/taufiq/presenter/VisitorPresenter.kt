package id.taufiq.presenter

import id.taufiq.api.builder.BuildApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created By Taufiq on 11/19/2020.
 *
 */
class VisitorPresenter(val view: VisitorView) {


    fun getAllVisitor() {
        CoroutineScope(Dispatchers.Main).launch {
            val getAll = BuildApi.buildApiService().getAllVisitor()
            if (getAll.isSuccessful) {
                getAll.body()?.visitor?.let { view.onSuccess(it) }
            }
        }

    }

    fun insertVisitor(
        nama: String,
        noHp: String,
        tglKunjungan: String,
        alamat: String,
        asal: String,
        tujuan: String
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            BuildApi.buildApiService().insertVisitor(nama, noHp, tglKunjungan, alamat, asal, tujuan)
        }

    }

    fun updateVisitor(
        id: String,
        nama: String,
        noHp: String,
        tglKunjungan: String,
        alamat: String,
        asal: String,
        tujuan: String
    ) {

        CoroutineScope(Dispatchers.Main).launch {
            BuildApi.buildApiService()
                .updateVisitor(id, nama, noHp, tglKunjungan, alamat, asal, tujuan)
        }

    }

    fun deleteVisitor(id: String) {
        CoroutineScope(Dispatchers.Main).launch {
            BuildApi.buildApiService().deleteVisitor(id)
        }


    }
}