import javax.swing.*;
import java.awt.*;

// 定义一个名为 Task 的类，继承自 JPanel
public class Task extends JPanel {
    private JLabel index;  // 用于显示任务索引的标签
    private JButton done;  // 表示任务完成的按钮
    private JButton remove; // 表示移除任务的按钮
    private JTextField taskname; // 用于输入任务名称的文本框

    // 构造方法，用于初始化 Task 对象
    public Task() {
        // 创建一个具有 1 行 10 列的网格布局管理器
        GridLayout layouttask = new GridLayout(1, 10);
        // 设置面板的首选大小
        this.setPreferredSize(new Dimension(10, 20));
        // 设置面板的背景颜色
        this.setBackground(new Color(149, 240, 12));
        // 设置面板的布局管理器
        this.setLayout(layouttask);

        // 初始化并配置任务索引标签
        index = new JLabel("Index");
        index.setPreferredSize(new Dimension(10, 20));
        index.setHorizontalAlignment(JLabel.LEFT);
        index.setBackground(new Color(12, 240, 198));
        this.add(index);  // 将索引标签添加到面板中

        // 初始化并配置任务名称输入框
        taskname = new JTextField("Enter Task");
        taskname.setPreferredSize(new Dimension(10, 20));
        taskname.setBorder(BorderFactory.createEmptyBorder());
        taskname.setBackground(new Color(12, 240, 198));
        this.add(taskname);  // 将任务名称输入框添加到面板中

        // 初始化并配置完成按钮
        done = new JButton("Done");
        done.setPreferredSize(new Dimension(10, 20));
        this.add(done);  // 将完成按钮添加到面板中

        // 初始化并配置移除按钮
        remove = new JButton("Remove");
        remove.setPreferredSize(new Dimension(10, 20));
        this.add(remove);  // 将移除按钮添加到面板中
    }

    // 定义一个方法，用于设置任务索引
    public void writeindexj1(int n) {
        this.index.setText(String.valueOf(n));  // 设置索引标签的文本
        this.revalidate();  // 重新验证面板
    }

    // 定义一个方法，返回完成按钮
    public JButton getdonej() {
        return this.done;
    }

    // 定义一个方法，返回移除按钮
    public JButton getremovej() {
        return this.remove;
    }

    // 定义一个方法，用于设置任务完成的状态
    public void donestatus() {
        this.setBackground(Color.GREEN);  // 设置面板的背景颜色为绿色
        this.index.setBackground(Color.GREEN);  // 设置索引标签的背景颜色为绿色
        this.taskname.setBackground(Color.GREEN);  // 设置任务名称输入框的背景颜色为绿色
        this.done.setBackground(Color.GREEN);  // 设置完成按钮的背景颜色为绿色
        this.remove.setBackground(Color.GREEN);  // 设置移除按钮的背景颜色为绿色
        this.revalidate();  // 重新验证面板
        //donestatus 方法用于将任务面板及其所有组件的背景颜色设置为绿色，表示任务已完成。
    }
}

