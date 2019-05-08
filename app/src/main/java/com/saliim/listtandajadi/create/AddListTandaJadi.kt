package com.saliim.listtandajadi.create

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.saliim.listtandajadi.R
import com.saliim.listtandajadi.api.API
import com.saliim.listtandajadi.model.DataKategoriMotor
import com.saliim.listtandajadi.model.InsertTandaJadi
import kotlinx.android.synthetic.main.activity_add_list_tanda_jadi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.NumberFormat

class AddListTandaJadi : AppCompatActivity(), AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    private var toolbar: Toolbar? = null

    var kategori_motor : ArrayList<DataKategoriMotor?>? = null

    var formatter: NumberFormat = DecimalFormat("#,###.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list_tanda_jadi)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Add Tanda Jadi"
//        titleSearch!!.text = "Add Activity"
//        titleSearch!!.setTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        getKategoriMotor {}

        btn_add.setOnClickListener {
            val inputTj = in_tanda_jadi.text.toString()
            val inputKM = spn_kategori_motor.selectedItem

            if (inputTj.isEmpty()){
                in_tanda_jadi.error = "kolom tidak boleh kosong"
            } else if (inputKM == null){
                Toast.makeText(this@AddListTandaJadi, "pilih kategori yg ada", Toast.LENGTH_LONG).show()
            }else{
                doCreate()
            }
        }

    }

    private fun doCreate() {
        val progressDialog = ProgressDialog(this@AddListTandaJadi)
        progressDialog.setMessage("Creating Tanda Jadi...")
        progressDialog.show()

        val create_by = "Hasbi"
        val tanda_jadi = java.lang.Double.parseDouble(in_tanda_jadi.text.toString())
        val kategori_motor = spn_kategori_motor.selectedItem.toString()

        val tanda_jadis = formatter.format(tanda_jadi)

        API.addTandaJadi(tanda_jadis, kategori_motor, create_by).enqueue(object : Callback<InsertTandaJadi> {
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

    fun getKategoriMotor(onFinish: () -> Unit){
        API.dataKategoriMotor().enqueue(object : Callback<ArrayList<DataKategoriMotor>>{
            override fun onResponse(call: Call<ArrayList<DataKategoriMotor>>, response: Response<ArrayList<DataKategoriMotor>>) {
                if (response.code() == 200){
                    kategori_motor = ArrayList()
                    kategori_motor?.add(0, null)
                    response.body()?.forEach { kategori_motor?.add(it) }
                    val adapter = CustomAdapter<DataKategoriMotor?>(this@AddListTandaJadi,
                        com.saliim.listtandajadi.R.layout.spinner_custom, com.saliim.listtandajadi.R.layout.spinner_dropdown_item,
                        kategori_motor?.toTypedArray()!!)

                    Log.d("kategoriMotor", ""+kategori_motor)

                    spn_kategori_motor.adapter = adapter

                    onFinish()
                }else{
                    Toast.makeText(this@AddListTandaJadi, "kategori tidak ada", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<DataKategoriMotor>>, t: Throwable) {

            }
        })
    }

    class CustomAdapter<T>(context: AddListTandaJadi, val viewResourceId: Int, val dropDownReourceId: Int, val list: Array<T>) : ArrayAdapter<T>(context, viewResourceId, dropDownReourceId, list) {

        internal var layoutInflater: LayoutInflater = context.layoutInflater

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
            return getCustomView(position, convertView, parent, dropDownReourceId)
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            return getCustomView(position, convertView, parent, viewResourceId)
        }


        fun getCustomView(position: Int, convertView: View?, parent: ViewGroup?, resourceId: Int): View {

            var view = convertView

            if (view == null) {
                view = layoutInflater.inflate(resourceId, parent, false)
            }

            val textView = view as? TextView
            if (list[position] != null) {
                textView?.text = list[position].toString()
            } else {
                textView?.text = "Pilih Kategori"
            }

            return view!!
        }

        override fun isEnabled(position: Int): Boolean {
            return position != 0
        }

    }
}
