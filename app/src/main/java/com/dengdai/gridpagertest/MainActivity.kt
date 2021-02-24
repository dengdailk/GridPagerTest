package com.dengdai.gridpagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import cn.mtjsoft.www.gridpager.GridPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val titles = arrayListOf<String>("周边游","景点","美食","电影","丽人","酒店住宿","火车票","买菜","美发","超市")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridpager.setDataAllCount(titles.size)// 设置数量总条数
                .setItemBindDataListener { imageView, textView, position -> // 自己进行数据的绑定，灵活度更高，不受任何限制
                    imageView.setImageResource(R.mipmap.ic_launcher)
                    textView!!.text = titles[position]

                    tip.text = "提示：字体大小有问题"
                }
                .setGridItemClickListener {
                    Toast.makeText(baseContext, "点击了" + titles[it], Toast.LENGTH_SHORT).show();
                }
                .show()
    }
}