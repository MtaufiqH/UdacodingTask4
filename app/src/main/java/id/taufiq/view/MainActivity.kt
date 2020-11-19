package id.taufiq.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.taufiq.R
import id.taufiq.adapter.VisitorAdapter
import id.taufiq.api.response.Visitor
import id.taufiq.presenter.VisitorPresenter
import id.taufiq.presenter.VisitorView
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity(), VisitorView {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val presenter = VisitorPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getAllVisitor()

        btn_add_visitor.setOnClickListener {
            val intent = Intent(this, MyVisitors::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getAllVisitor()
    }

    override fun onSuccess(data: List<Visitor>) {
        rv_visitor.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = VisitorAdapter(this@MainActivity, data) { item ->
                val intent = Intent(this@MainActivity, MyVisitors::class.java)
                intent.putExtra("DATA_VISITOR", item)
                startActivity(intent)
            }
        }
    }

    override fun onFailure(message: String) {
        Log.d(TAG, "onFailure: $message")
    }
}
