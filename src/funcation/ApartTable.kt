package funcation

import model.Apartment
import funcation.select.SelectApartments
import java.util.*
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

/**
 * Created by Joki on 2017/6/9.
 */

/**
 * 填充apartment表
 */
fun JTable.fillTable(res : Vector<Apartment>){
    var tableModel : DefaultTableModel
    tableModel = this.model as DefaultTableModel //table中的元素转为Vector来管理

    tableModel.rowCount = 0

    for ( r : Apartment in res){
        val str = Array<String>(3,{""} )

        str[0] = r.no
        str[1] = r.name
        str[2] = r.managerNo+""

        //添加数据到apartTable
        tableModel.addRow(str)
    }
    //更新表格
    this.invalidate()
}


/**
 *取得用户所选行的详细信息
 */
fun JTable.getApartInfo() : Vector<Apartment> {

    var tableModel = this.model as DefaultTableModel


    return SelectApartments().search(tableModel.getValueAt(selectedRow,0) as String)
}
