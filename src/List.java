import javax.swing.*;
import java.awt.*;

// 定义一个名为 List 的类，继承自 JPanel
public class List extends JPanel {

    // 构造方法，用于初始化 List 对象
    public List() {
        // 创建一个具有 10 行 1 列的网格布局管理器
        GridLayout Layout = new GridLayout(10, 1);
        // 设置垂直间距为 5 像素
        Layout.setVgap(5);
        // 将布局管理器设置为当前面板的布局
        setLayout(Layout);
    }

    // 定义一个方法 indexnum，用于为组件设置索引
    public void indexnum() {
        // 获取当前面板中的所有组件
        Component[] listcomp = this.getComponents();

        // 遍历每个组件
        for (int i = 0; i < listcomp.length; i++) {
            // 如果组件是 Task 类型的实例
            if (listcomp[i] instanceof Task) {
                // 调用 Task 对象的 writeindexj1 方法，传递当前索引（从 1 开始）
                ((Task) listcomp[i]).writeindexj1(i + 1);
            }
        }
    }
}
