package funcation

import com.sun.javafx.collections.MappingChange
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

/**
 * Created by Joki on 2017/6/10.
 */

/**
 * 获得所选行的第一个单元格
 */
fun JTable.getSelectRowsValue() : ArrayList<String> {
    var selectRows = this.selectedRows.size
    var tableModel = this.model as DefaultTableModel

    var list = ArrayList<String>()

    if (selectRows >= 1){
        val array = this.selectedRows//取得所选单元行
        for (i in array){
            list.add(tableModel.getValueAt(i,0).toString())
        }
    }

    return list

}
//查询宿舍时get所选行的前两列的元素，用map存储
fun JTable.getSelectMap() : Map<String,String> {
    var selectRows = this.selectedRows.size
    var tableModel = this.model as DefaultTableModel
    var map = hashMapOf<String,String>()
    if (selectRows >= 1){
        val array = this.selectedRows//取得所选单元行
        for (i in array){
            map.put(tableModel.getValueAt(i,0) as String,tableModel.getValueAt(i,1) as String)
        }
    }
    return map
}