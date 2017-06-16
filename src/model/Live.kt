package model

/**
 * Created by Joki on 2017/6/7.
 */
class Live(var apartNo : String,
           var dormNo : String,
           var bedNo : Int,
           var sno : String?,
           var sname : String?,
           var stel :String?){

    override fun toString(): String {
        return "公寓号：" + apartNo + "\n宿舍号：" + dormNo + "\n床号：" + bedNo.toString() +
                "\n学号：" + sno + "\n姓名：" + sname +"\n联系方式：" +stel
    }

}