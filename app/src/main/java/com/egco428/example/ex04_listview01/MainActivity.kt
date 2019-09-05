package com.egco428.example.ex04_listview01

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.view.*
import java.security.AccessControlContext
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val listView = findViewById<ListView>(R.id.mainListView)
//        val redColor = Color.parseColor("#FF0000")
//        listView.setBackgroundColor(redColor)
        mainListView.adapter = myCustomAdapter(this)
    }

    private class myCustomAdapter(context: Context):BaseAdapter(){
        private val names = arrayListOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

        private val mContext:Context
        init {
            mContext = context
        }

        override fun getCount(): Int {

            return names.size*7
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "Hello World"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

//            val whiteColor = Color.parseColor("#FFFFFF")
//            val greyColor = Color.parseColor("#E0E0E0")

            val yellow = Color.YELLOW
            val pink = Color.parseColor("#FFC0CB")
            val green = Color.GREEN
            val orange = Color.parseColor("#FFA500")
            val blue = Color.BLUE
            val purple = Color.parseColor("#800080")
            val red = Color.RED

            val layoutInflater=LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main,viewGroup, false)



            rowMain.nameTextView.text = names.get(position%7)
            when(position%7){
                0->rowMain.setBackgroundColor(yellow)
                1->rowMain.setBackgroundColor(pink)
                2->rowMain.setBackgroundColor(green)
                3->rowMain.setBackgroundColor(orange)
                4->rowMain.setBackgroundColor(blue)
                5->rowMain.setBackgroundColor(purple)
                6->rowMain.setBackgroundColor(red)
            }
            rowMain.positionTextView.text = "Row Number: $position"

            return rowMain

        }

    }
}
