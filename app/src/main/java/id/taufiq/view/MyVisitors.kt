package id.taufiq.view

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import id.taufiq.R
import id.taufiq.api.response.Visitor
import id.taufiq.presenter.VisitorPresenter
import id.taufiq.presenter.VisitorView
import kotlinx.android.synthetic.main.activity_my_visitors.*


class MyVisitors : AppCompatActivity(), VisitorView {

    private val presenter = VisitorPresenter(this)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_visitors)

        val data = intent.getParcelableExtra<Visitor>("DATA_VISITOR")

        if (data != null) {
            et_name.setText(data.nama)
            et_nomor_hp.setText(data.noHp)
            et_alamat.setText(data.alamat)
            et_tgl_kunjungan.setText(data.tanggalKunjungan)
            et_asal_sekolah.setText(data.asalSekolah)
            et_tujuan.setText(data.tujuan)

            doneButton.text = "Update"

            deleteButton.visibility = View.VISIBLE

            deleteButton.setOnClickListener {
                val alert = AlertDialog.Builder(this)
                with(alert) {
                    setTitle("Deleting Data")
                    setMessage("Are you sure to delete ${data.nama}")
                    setPositiveButton("Delete") { dialogInterface: DialogInterface, _ ->
                        presenter.deleteVisitor(data.id)
                        dialogInterface.dismiss()
                        finish()
                    }

                    setNegativeButton("Cancel") { dialogInterface: DialogInterface, _ ->
                        dialogInterface.dismiss()
                    }


                }.show()


            }

        }





        when (doneButton.text) {
            "Update" -> {
                doneButton.setOnClickListener {

                        val nama = et_name.text.toString()
                        val noHp = et_nomor_hp.text.toString()
                        val alamat = et_alamat.text.toString()
                        val tgl = et_tgl_kunjungan.text.toString()
                        val asal = et_asal_sekolah.text.toString()
                        val tujuan = et_tujuan.text.toString()

                        if (nama.isEmpty() && noHp.isEmpty() && alamat.isEmpty() && tgl.isEmpty() && asal.isEmpty() && tujuan.isEmpty()) {

                            et_name.error = "cannot be empty!"
                            et_nomor_hp.error = "cannot be empty!"
                            et_alamat.error = "cannot be empty!"
                            et_tgl_kunjungan.error = "cannot be empty!"
                            et_asal_sekolah.error = "cannot be empty!"
                            et_tujuan.error = "cannot be empty!"
                        } else {
                            if (data != null) {
                                presenter.updateVisitor(data.id,nama,
                                    noHp,
                                    tgl,
                                    alamat,
                                    asal,
                                    tujuan
                                )
                            }
                            finish()
                    }
                }


            }else -> {
                doneButton.setOnClickListener {

                    val nama = et_name.text.toString()
                    val noHp = et_nomor_hp.text.toString()
                    val alamat = et_alamat.text.toString()
                    val tgl = et_tgl_kunjungan.text.toString()
                    val asal = et_asal_sekolah.text.toString()
                    val tujuan = et_tujuan.text.toString()

                    if (nama.isEmpty() && noHp.isEmpty() && alamat.isEmpty() && tgl.isEmpty() && asal.isEmpty() && tujuan.isEmpty()) {

                        et_name.error = "cannot be empty!"
                        et_nomor_hp.error = "cannot be empty!"
                        et_alamat.error = "cannot be empty!"
                        et_tgl_kunjungan.error = "cannot be empty!"
                        et_asal_sekolah.error = "cannot be empty!"
                        et_tujuan.error = "cannot be empty!"
                    } else {
                        presenter.insertVisitor(nama, noHp, tgl, alamat, asal, tujuan)
                        finish()
                    }
                }
            }


        }


        cancelButton.setOnClickListener {
            finish()
        }

    }


    override fun onSuccess(data: List<Visitor>) {
        Log.d(TAG, "onSuccess: inserting data")
    }

    override fun onFailure(message: String) {
        Log.d(TAG, "onFailure: failure")
    }

    companion object {

        private const val TAG = "MyVisitors"
    }
}
