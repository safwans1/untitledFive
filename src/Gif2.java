import javax.swing.*;
import javax.net.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;


public class Gif2 extends JFrame{
    private ImageIcon image3;
    private JLabel label3;

    public Gif2(){
        image3 = new ImageIcon("C:\\Users\\safwa\\IdeaProjects\\untitled5\\src\\wordifycutscene2.gif");
        label3 = new JLabel(image3);
        add(label3);
    }


}
