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

    fun getVisitorById(){}

    fun insertVisitor() {}
    fun updateVisitor() {}
    fun deleteVisitor() {}
}