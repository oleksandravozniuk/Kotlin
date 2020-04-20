package com.example.lab3

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.lab3.Models.Order
import com.example.lab3.R.id.orderText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.order.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQueryAll()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.addOrder-> {
                    var intent = Intent(this, OrderActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        loadQueryAll()
    }

    fun loadQueryAll() {

        var dbManager = OrderDbManager(this)
        val cursor = dbManager.queryAll()
        var listOrders = ArrayList<Order>()

        listOrders.clear()
        if (cursor.moveToFirst()) {

            do {
                val id = cursor.getInt(cursor.getColumnIndex("Id"))
                val text = cursor.getString(cursor.getColumnIndex("Text"))
                val color = cursor.getString(cursor.getColumnIndex("Color"))
                val price = cursor.getString(cursor.getColumnIndex("Price"))

                listOrders.add(Order(id,text, color,price))

            } while (cursor.moveToNext())
        }

        var ordersAdapter = OrdersAdapter(this, listOrders)
        ordersList.adapter = ordersAdapter
    }

    inner class OrdersAdapter : BaseAdapter {

        private var ordersList = ArrayList<Order>()
        private var context: Context? = null

        constructor(context: Context, ordersList: ArrayList<Order>) : super() {
            this.ordersList = ordersList
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            var view: View

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.order,parent, false)
            }
            else
                view=convertView

            var mOrder = ordersList[position]

            view?.findViewById<TextView>(R.id.orderId)?.text = mOrder.Id.toString()
            view?.findViewById<TextView>(R.id.orderText)?.text = mOrder.Text
            view?.findViewById<TextView>(R.id.orderColor)?.text = mOrder.Color
            view?.findViewById<TextView>(R.id.orderPrice)?.text = mOrder.Price

            view?.findViewById<ImageView>(R.id.ivDelete)?.setOnClickListener{
                var dbManager = OrderDbManager(this.context!!)
                val selectionArgs = arrayOf(mOrder.Id.toString())
                dbManager.delete("Id=?", selectionArgs)
                loadQueryAll()
            }

            return view
        }

        override fun getItem(position: Int): Any {
            return ordersList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return ordersList.size
        }
    }

}
