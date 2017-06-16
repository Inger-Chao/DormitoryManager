package view.admin

import funcation.OperatorAdvice
import model.Advice
import java.util.*
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

/**
 * Created by Joki on 2017/6/13.
 */

fun JTable.fillTable(advices: Vector<Advice>){

    var tableModel = this.model as DefaultTableModel //table中的元素转为Vector来管理

    tableModel.rowCount = 0

    for ( r : Advice in advices){
        val str = Array<String>(2,{""} )

        str[0] = r.text
        str[1] = r.date.toString()

        //添加数据到apartTable
        tableModel.addRow(str)
    }
    //更新表格
    this.invalidate()
}

fun JTable.getAdviceInfo() : Advice {

    var tableModel = this.model as DefaultTableModel


    return OperatorAdvice().selectByClick(tableModel.getValueAt(selectedRow,0) as String,
            tableModel.getValueAt(selectedRow,1) as String)

}