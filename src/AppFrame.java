import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 定义一个名为 AppFrame 的类，继承自 JFrame
public class AppFrame extends JFrame {
    // 创建标题栏、按钮面板和任务列表
    TitleBar Title = new TitleBar(); // 插入标题栏到大容器
    BtnPanel BtnPanel = new BtnPanel(); // 插入按钮面板到大容器
    List list = new List(); // 插入任务列表到大容器

    // 构造方法，用于初始化 AppFrame 对象
    public AppFrame() {
        this.setSize(900, 700); // 设置窗口大小
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 设置窗口关闭操作
        this.setVisible(true); // 设置窗口可见
        this.add(Title, BorderLayout.NORTH); // 将标题栏添加到窗口的北部
        this.add(BtnPanel, BorderLayout.SOUTH); // 将按钮面板添加到窗口的南部
        this.add(list, BorderLayout.CENTER); // 将任务列表添加到窗口的中部

        // 获取按钮面板中的添加任务按钮和删除任务按钮
        JButton addtask = BtnPanel.getAddTaskButton();
        JButton deletetask = BtnPanel.getDeleteTaskButton();

        // 为添加任务按钮添加鼠标监听器
        addtask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Task task = new Task(); // 创建一个新的任务
                list.add(task); // 将任务添加到任务列表
                list.indexnum(); // 更新任务索引
                revalidate(); // 重新验证面板

                // 为任务的完成按钮添加鼠标监听器
                JButton done = task.getdonej();
                done.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        task.donestatus(); // 设置任务完成状态
                        revalidate(); // 重新验证面板
                    }
                });

                // 为任务的移除按钮添加鼠标监听器
                JButton remove = task.getremovej();
                remove.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        list.remove(task); // 从任务列表中移除任务
                        list.indexnum(); // 更新任务索引
                        repaint(); // 重新绘制面板
                    }
                });
            }
        });

        // 为删除任务按钮添加鼠标监听器
        deletetask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Component[] tasklist = list.getComponents(); // 获取任务列表中的所有组件
                for (Component component : tasklist) {
                    if (component instanceof Task) { // 如果组件是任务类型
                        list.remove(component); // 从任务列表中移除组件
                    }
                }
                revalidate(); // 重新验证面板
                repaint(); // 重新绘制面板
            }
        });
    }

    // 主方法，程序的入口点
    public static void main(String[] args) {
        new AppFrame(); // 创建一个 AppFrame 对象
    }
}


