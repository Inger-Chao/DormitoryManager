package model

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Joki on 2017/6/13.
 */
class Advice(var apartNo : String,
             var text: String,
             var date : Date) {

    override fun toString(): String {
        return "公寓号：" + apartNo + "\n文本：" + text + "\n日期：" + dateToString(date);
    }

    fun dateToString(date: Date): String{
        var dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(date)
    }


}