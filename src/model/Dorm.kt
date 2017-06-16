package model

/**
 * Created by Joki on 2017/6/7.
 */
//宿舍实体类
class Dorm (var apartNo: String ,
            var dormNo : String ,
            var bedNum : Int?,
            var bedIn: Int?,
            var managerNo : String?){

    override fun toString(): String {
        return "公寓号：" + apartNo +"\n宿舍号："+ dormNo + "\n床位：" + bedNum +
                "\n已住人数："+ bedIn+"\n寝室长：" + managerNo
    }
}