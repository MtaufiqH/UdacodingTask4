package id.taufiq

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.taufiq.adapter.VisitorAdapter
import id.taufiq.api.response.Visitor
import id.taufiq.presenter.VisitorPresenter
import id.taufiq.presenter.VisitorView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), VisitorView {

    companion object {
        private const val TAG = "MainFragment"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val presenter = VisitorPresenter(this)
        presenter.getAllVisitor()


        btn_add_visitor.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_bottomDialog)
        }
    }

    override fun onSuccess(data: List<Visitor>) {

        rv_visitor.apply {
            layoutManager =
                LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
            adapter = view?.context?.let {
                VisitorAdapter(it, data) {

                }
            }
        }


    }

    override fun onFailure(message: String) {
        Log.d(TAG, "onFailure: $message")
    }
}