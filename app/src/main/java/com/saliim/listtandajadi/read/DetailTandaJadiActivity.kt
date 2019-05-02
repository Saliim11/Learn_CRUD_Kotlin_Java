package com.saliim.listtandajadi.read

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.saliim.listtandajadi.R
import com.saliim.listtandajadi.api.API
import com.saliim.listtandajadi.update.UpdateTandaJadiActivity
import kotlinx.android.synthetic.main.activity_detail_tanda_jadi.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailTandaJadiActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tanda_jadi)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Detail Tanda Jadi"


        val idTj = this.intent.getStringExtra(ID_TJ)
        val tj = this.intent.getStringExtra(TANDA_JADI)
//        val createByTj = this.intent.getStringExtra(CREATE_BY)

        txt_detail_tj.text = "Rp.$tj"

        btn_pindah_update.setOnClickListener {
            val intent = Intent(this@DetailTandaJadiActivity, UpdateTandaJadiActivity::class.java)
            intent.putExtra(UpdateTandaJadiActivity.UP_ID_TJ, idTj)
            intent.putExtra(UpdateTandaJadiActivity.UP_TANDA_JADI, tj)
            startActivity(intent)
        }

        btn_pindah_delete.setOnClickListener {
            doDelete()
        }

    }

    private fun doDelete() {
        val idTj = this.intent.getStringExtra(ID_TJ)

        val builder = AlertDialog.Builder(this@DetailTandaJadiActivity)
        builder.setTitle("Peringatan!")
        builder.setMessage("Anda Yakin Ingin Menghapus Data Ini?")
        builder.setPositiveButton("Ya"){dialog, which ->

            val id = idTj
            API.deleteTandaJadi(id).enqueue(object : Callback<ResponseBody>{
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    val intent = Intent(this@DetailTandaJadiActivity, MainActivity::class.java)
                    this@DetailTandaJadiActivity.startActivity(intent)
                    Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
                    finish()
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(applicationContext, "fail", Toast.LENGTH_SHORT).show()
                }

            })
        }
        builder.setNegativeButton("Tidak"){dialog, which ->

        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    companion object {
        val ID_TJ = "id"
        val TANDA_JADI = "tanda_jadi"
        val CREATE_BY = "create_by"
    }

}
