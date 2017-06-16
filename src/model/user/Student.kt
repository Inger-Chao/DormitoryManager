package model.user

import model.user.abstarct.User

/**
 * Created by Joki on 2017/6/8.
 */
class Student(no : String ,var name : String,
              var sex : String?,var tel : String,
              var academic :String?, var dept : String?,
              var apartNO: String?,var dormNo : String?,
              var bedNo : Int? , var address : String?) : User(no){

    override fun toString(): String{
        return "学号：" + no +"\n姓名：" + name + "\n性别："+ sex +"\n联系方式："+ tel +
                "\n学院："+ academic +"\n专业："+ dept+ "\n公寓号：" + apartNO+
                "\n宿舍号：" + dormNo +"\n床位："+ bedNo +"\n家庭地址："+ address
    }

}