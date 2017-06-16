package model

/**
 * Created by Joki on 2017/6/7.
 * 公寓实体类
 */
class Apartment (var no : String,
                 var name : String,
                 var location : String?,
                 var floor : Int?,
                 var max : Int?,
                 var In : Int?,
                 var managerNo : String?){

    override fun toString(): String {
        return "公寓号：" + no +"\n公寓名："+ name + "\n地点：" + location +
                "\n层数："+ floor+"\n可容纳人数：" + max+"\n现住人数：" + In+"\n负责人：" + managerNo
    }
}