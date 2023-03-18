import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    public static int width = 600, height = 600;
    public static boolean start = false;

    Button button = new Button("Start");
    Panel panel = new Panel();

    Window() {
        this.setTitle("Game of life");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(panel);

    }

    public void init() {
        JScrollPane scroll = new JScrollPane(panel);
        this.add(scroll);


        button.setSize(59,29);
        button.addActionListener(this);
        this.add(button,BorderLayout.PAGE_START);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            start = true;
            System.out.println(start);
        }
    }
}
