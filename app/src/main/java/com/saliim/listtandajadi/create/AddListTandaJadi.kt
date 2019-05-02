package com.saliim.listtandajadi.create

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Toast
import com.saliim.listtandajadi.R
import com.saliim.listtandajadi.api.API
import com.saliim.listtandajadi.model.InsertTandaJadi
import kotlinx.android.synthetic.main.activity_add_list_tanda_jadi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddListTandaJadi : AppCompatActivity() {

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list_tanda_jadi)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Add Activity")
//        titleSearch!!.text = "Add Activity"
//        titleSearch!!.setTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        btn_add.setOnClickListener {
            val inputTj = in_tanda_jadi.text.toString()

            if (inputTj.isEmpty()){
                in_tanda_jadi.error = "kolom tidak boleh kosong"
            }else{
                doCreate()
            }
        }

    }

    private fun doCreate() {
        val progressDialog = ProgressDialog(this@AddListTandaJadi)
        progressDialog.setMessage("Creating...")
        progressDialog.show()

        val create_by = "1"
        val tanda_jadi = in_tanda_jadi.text.toString()

        API.addTandaJadi(tanda_jadi, create_by).enqueue(object : Callback<InsertTandaJadi> {
            override fun onResponse(call: Call<InsertTandaJadi>, response: Response<InsertTandaJadi>) {
                if (response.code() == 200){
                    Log.i("insert", "" + response.body())
                    Toast.makeText(this@AddListTandaJadi, "sukses", Toast.LENGTH_LONG).show()
                    progressDialog.dismiss()
                    finish()
                }else{
                    Toast.makeText(this@AddListTandaJadi, "gagal", Toast.LENGTH_LONG).show()
                    progressDialog.dismiss()
                }

            }

            override fun onFailure(call: Call<InsertTandaJadi>, t: Throwable) {
                Toast.makeText(this@AddListTandaJadi, "gagal", Toast.LENGTH_LONG).show()
                progressDialog.dismiss()
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
