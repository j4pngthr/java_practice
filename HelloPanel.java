// import java.awt.Graphics;
// import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class HelloPanel extends JPanel {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("FRAME タイトル");
    frame.setVisible(true);
  }
  public void paint(Graphics g) {
    g.setColor(new Color(0, 0, 255));
    g.drawString("こんにちは", 10, 10);
    g.drawLine(0, 0, 100, 100);

    g.setColor(new Color(255, 0, 0));
    g.fillRect(100, 100, 200, 300);
    g.drawOval(100, 100, 200, 300);
    g.drawOval(100, 100, 200, 300);

    g.setColor(new Color(0, 255, 0));
    int x[] = { 10, 30, 20 };
    int y[] = { 50, 50, 20 };
    g.fillPolygon(x, y, 3);
  }
}
