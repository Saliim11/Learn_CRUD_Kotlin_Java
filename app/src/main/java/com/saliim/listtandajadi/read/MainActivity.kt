package com.saliim.listtandajadi.read

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Toast
import com.saliim.listtandajadi.R
import com.saliim.listtandajadi.RecyclerItemClickListener
import com.saliim.listtandajadi.api.API
import com.saliim.listtandajadi.create.AddListTandaJadi
import com.saliim.listtandajadi.model.DataTandaJadi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    var tempDatas: ArrayList<DataTandaJadi>? = null

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("List Tanda Jadi")

        add_button.setOnClickListener {
            val intent = Intent(this@MainActivity, AddListTandaJadi::class.java)
            startActivity(intent)
        }

        recyclerTandaJadi.addOnItemTouchListener(
            RecyclerItemClickListener(
                this@MainActivity,
                RecyclerItemClickListener.OnItemClickListener { view, position ->
                    val intent =
                        Intent(this@MainActivity, DetailTandaJadiActivity::class.java)

                    intent.putExtra(DetailTandaJadiActivity.ID_TJ, tempDatas!![position].id)
                    intent.putExtra(DetailTandaJadiActivity.TANDA_JADI, tempDatas!![position].tandaJadi)
                    intent.putExtra(DetailTandaJadiActivity.CREATE_BY, tempDatas!![position].createBy)

//                    Log.d("CEK ID", "" + tempDatas!![position].tandaJadi)

                    startActivity(intent)
                })
        )

        getData()

        swipeRefreshLayout.setOnRefreshListener { getData() }
    }

    override fun onResume() {
        super.onResume()
        swipeRefreshLayout.isRefreshing = true
        getData()
        swipeRefreshLayout.setOnRefreshListener { getData() }
    }

    fun getData() {
        API.getDataTandaJadi().enqueue(object : Callback<ArrayList<DataTandaJadi>> {
            override fun onResponse(call: Call<ArrayList<DataTandaJadi>>, response: Response<ArrayList<DataTandaJadi>>) {
                if (response.code() == 200) {
                    tempDatas = response.body()
                    Log.i("Data Index", "" + tempDatas)
                    if (tempDatas == null) {
                        tv_no_data.visibility = View.VISIBLE
                    } else {
                        tv_no_data.visibility = View.GONE
                        recyclerTandaJadi?.setHasFixedSize(true)
                        recyclerTandaJadi?.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerTandaJadi?.adapter = TandaJadiAdapter(tempDatas)
                    }

                } else {
                    Toast.makeText(this@MainActivity, "Gagal", Toast.LENGTH_LONG).show()
                }
                swipeRefreshLayout.isRefreshing = false

            }

            override fun onFailure(call: Call<ArrayList<DataTandaJadi>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "gagal", Toast.LENGTH_SHORT).show()
                swipeRefreshLayout.isRefreshing = false

            }
        })
    }

    //NOTES:
//    create_by dan modi_by ambil dari login
}
