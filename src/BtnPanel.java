import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BtnPanel extends JPanel { //create the small container

    Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);//给emptyBorder 一个variable，create一个无颜色的边框 只是留上下左右5位数的格子
    private JButton addtask; // Declare addtask button
    private JButton deletetask; // Declare deletetask button

    public BtnPanel() { //create the button
        this.setPreferredSize(new Dimension(400, 80));  //the container's size
        this.setBackground(new Color(129, 207, 133)); //the container's colour

        addtask = new JButton("Add Task"); //assign the addtask to the Add Task JButton
        addtask.setBorder(emptyBorder);// emptyBorder 运用到 addtask（JButton）
        addtask.setFont(new Font("Tahoma", Font.BOLD, 20));//addtask's 的字体
        this.add(addtask); //insert the addtask to the button

        deletetask = new JButton("Delete All Task");//assign the deletetask to the Delete All Task JButton
        deletetask.setBorder(emptyBorder); // emptyBorder 运用到  deletetask（JButton）
        deletetask.setFont(new Font("Tahoma", Font.BOLD, 20));//deletetask's 的字体
        this.add(deletetask); // insert the deletetask to the button

    }

    public JButton getAddTaskButton() { // 声明 getAddTaskButton 方法，用于返回 addtask 按钮
        return addtask;
    }

    public JButton getDeleteTaskButton() { // 声明 getDeleteTaskButton 方法，用于返回 deletetask 按钮
        return deletetask;
    }
}
