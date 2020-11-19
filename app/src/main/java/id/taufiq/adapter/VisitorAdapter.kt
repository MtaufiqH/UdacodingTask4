package id.taufiq.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.taufiq.R
import id.taufiq.api.response.Visitor
import kotlinx.android.synthetic.main.visitor_row.view.*

/**
 * Created By Taufiq on 11/19/2020.
 *
 */
class VisitorAdapter(
    val context: Context,
    val data: List<Visitor>,
    val listener: (Visitor) -> Unit
) : RecyclerView.Adapter<VisitorAdapter.VisitorViewHolder>() {


    class VisitorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun binding(context: Context, data: Visitor, listener: (Visitor) -> Unit) {
            with(itemView) {

                tv_nama_visitor.text = data.nama
                tv_tgl_kunjungan.text = data.tanggalKunjungan
                tv_asal_kampus.text = data.asalSekolah

                setOnClickListener {
                    listener(data)
                }


            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitorViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.visitor_row, parent, false)

        return VisitorViewHolder(view)
    }

    override fun onBindViewHolder(holder: VisitorViewHolder, position: Int) {
        holder.binding(context, data[position],listener)
    }

    override fun getItemCount(): Int = data.size

}