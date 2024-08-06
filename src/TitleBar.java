import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel { //create the small container

    JLabel TitleText= new JLabel("To DO List App"); //the container show the word todo list app
    public TitleBar() //crate the titlebar
    {
        this.setPreferredSize(new Dimension(20, 100)); // the small container size
        this.setBackground(new Color(90, 143, 101)); // the small container colour

        TitleText.setPreferredSize(new Dimension(200, 80)); //the word in the small container's size
        TitleText.setFont(new Font("Times New Roman", Font.BOLD, 25)); //the word in the small container's size and font
        TitleText.setHorizontalAlignment(SwingConstants.CENTER); //the word in the small container located in center place
        this.add(TitleText); //insert the TitleText into the small container

    }
}