package model.user

import model.user.abstarct.User

/**
 * Created by Joki on 2017/6/8.
 */
class Admin(no : String, var name:String,
            var sex : String?,var age :Int?,
            var tel : String,var apartNo:String?,
            var address : String?,
            var workAge : Int?): User(no){

    override fun toString(): String {
        return "工号：" + no +"\n姓名：" + name + "\n性别："+ sex +"\n年龄："+ age +"\n联系方式："+ tel +
                "\n公寓号：" + apartNo+ "\n家庭地址："+ address + "\n工龄：" + workAge
    }
}