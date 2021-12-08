// import java.awt.Graphics;
// import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class HelloPanel extends JPanel {
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    HelloPanel app = new HelloPanel();

    frame.getContentPane().add(app);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(0, 0, 255, 255); // displayにおける座標，幅，高さ
    frame.setTitle("FRAME タイトル");
    frame.setVisible(true);
  }
  public void paint(Graphics g) {
    // g.setColor(new Color(255, 255, 255));
    // g.drawString("こんにちは", 10, 10); // 文字
    // g.drawLine(0, 0, 100, 100); // 線
    //
    // g.setColor(new Color(255, 0, 0));
    // g.fillRect(100, 100, 200, 300);
    // // g.drawOval(100, 100, 200, 300); // 楕円を描く, x, y, width, height
    //
    // g.setColor(new Color(0, 255, 0));
    // int x[] = { 10, 30, 20 }; // この3点で三角形
    // int y[] = { 50, 50, 20 };
    // g.fillPolygon(x, y, 3);

    // g.setColor(new Color(0, 0, 0));
    // for (int i = 0; i < 3; ++i) {
    //   for (int j = 0; j < 3; ++j) {
    //     if ((i + j) % 2 != 0) continue;
    //     g.fillRect(100 * i, 100 * j, 100, 100);
    //   }
    // }

    for (int i = 0; i < 255; ++i) {
      g.setColor(new Color(0, 0, i));
      g.drawLine(i, 0, i, 255);
    }
  }
}
