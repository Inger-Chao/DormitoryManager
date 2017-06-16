package funcation

import model.Dorm
import funcation.select.SelectDorms
import java.util.*
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

/**
 * Created by Joki on 2017/6/10.
 */

fun JTable.fillTable(res : Vector<Dorm>){
    var tableModel = this.model as DefaultTableModel //table中的元素转为Vector来管理

    tableModel.rowCount = 0

    for ( r : Dorm in res){
        val str = Array<String>(3,{""} )

        str[0] = r.apartNo
        str[1] = r.dormNo
        str[2] = r.bedIn.toString()+""

        //添加数据到apartTable
        tableModel.addRow(str)
    }
    //更新表格
    this.invalidate()
}

/**
 *取得用户所选行的详细信息
 */
fun JTable.getDormInfo() : Dorm {

    var tableModel = this.model as DefaultTableModel


    return SelectDorms().search(tableModel.getValueAt(selectedRow,0) as String
            ,tableModel.getValueAt(selectedRow,1) as String).get(0)
}
