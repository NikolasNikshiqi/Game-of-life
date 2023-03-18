import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]){
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Window window = new Window();
                    window.init();
                    window.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
