package util

import java.awt.Font
import javax.swing.UIManager

/**
 * 设置所有字体为微软雅黑，字号为18
 * Created by Joki on 2017/6/7.
 */

var heiti : Font = Font("微软雅黑" , Font.PLAIN,16)

val names = listOf<String>("Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
        "JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
        "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
        "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
        "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
        "PasswordField","TextField", "Table", "Label", "Viewport",
        "RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame")

fun setFont(){

    var item : String;

    for (item in names){
        UIManager.put(item + ".font", heiti)
    }
}