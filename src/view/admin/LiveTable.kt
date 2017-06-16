package view.admin

import model.Live
import funcation.select.SelectAdminInfo
import funcation.selectview.SelectCurrentAdminView
import util.UserService
import java.util.*
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

/**
 * Created by Joki on 2017/6/12.
 */


fun JTable.fillTable(lives : Vector<Live>){
    var tableModel = this.model as DefaultTableModel //table中的元素转为Vector来管理

    tableModel.rowCount = 0

    for ( r : Live in lives){
        val str = Array<String>(5,{""} )

        str[0] = r.dormNo
        str[1] = r.bedNo.toString()
        str[2] = r.sno+""
        str[3] = r.sname+""
        str[4] = r.stel+""

        //添加数据到apartTable
        tableModel.addRow(str)
    }
    //更新表格
    this.invalidate()
}

/**
 *取得用户所选行的详细信息
 */
fun JTable.getLiveInfo() : Live {

    var tableModel = this.model as DefaultTableModel


    return SelectCurrentAdminView().selectConcreteLive(SelectAdminInfo()
            .select(UserService.getInstance().currentUser.no),
            tableModel.getValueAt(selectedRow,0) as String,
            Integer.parseInt(tableModel.getValueAt(selectedRow,1) as String))
}