package id.taufiq.presenter

import id.taufiq.api.response.Visitor

/**
 * Created By Taufiq on 11/19/2020.
 *
 */
interface VisitorView {

    fun onSuccess(data: List<Visitor>)
    fun onFailure(message: String)
}