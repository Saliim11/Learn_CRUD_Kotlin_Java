package com.saliim.listtandajadi.update

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Toast
import com.saliim.listtandajadi.R
import com.saliim.listtandajadi.api.API
import com.saliim.listtandajadi.model.UpdateTandaJadi
import com.saliim.listtandajadi.read.MainActivity
import kotlinx.android.synthetic.main.activity_add_list_tanda_jadi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateTandaJadiActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list_tanda_jadi)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Update Tanda Jadi")
//        titleSearch!!.text = "Add Activity"
//        titleSearch!!.setTextColor(Color.WHITE)

        val upTj = this.intent.getStringExtra(UP_TANDA_JADI)

        in_tanda_jadi.setText(upTj)

        add_activity.setOnClickListener {

            val inputTj = in_tanda_jadi.text.toString()

            if (inputTj.isEmpty()){
                in_tanda_jadi.setError("kolom tidak boleh kosong")
            }else{
                doUpdate()
            }

        }

    }

    private fun doUpdate() {
        val progressDialog = ProgressDialog(this@UpdateTandaJadiActivity)
        progressDialog.setMessage("Updating...")
        progressDialog.show()

        val id = this.intent.getStringExtra(UP_ID_TJ)
        val mod_by = "2"
        val tanda_jadi = in_tanda_jadi.text.toString()

        API.editTandaJadi(id, tanda_jadi, mod_by).enqueue(object : Callback<UpdateTandaJadi>{
            override fun onResponse(call: Call<UpdateTandaJadi>, response: Response<UpdateTandaJadi>) {
                if (response.code() == 200){
                    Log.i("update", "" + response.body())
                    Toast.makeText(this@UpdateTandaJadiActivity, "sukses", Toast.LENGTH_LONG).show()
                    progressDialog.dismiss()
                    val intent = Intent(this@UpdateTandaJadiActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this@UpdateTandaJadiActivity, "gagal", Toast.LENGTH_LONG).show()
                    progressDialog.dismiss()
                }
            }

            override fun onFailure(call: Call<UpdateTandaJadi>, t: Throwable) {
                Toast.makeText(this@UpdateTandaJadiActivity, "gagal", Toast.LENGTH_LONG).show()
                progressDialog.dismiss()
            }
        })
    }

    companion object {
        val UP_ID_TJ = "id"
        val UP_TANDA_JADI = "tanda_jadi"
    }
}
