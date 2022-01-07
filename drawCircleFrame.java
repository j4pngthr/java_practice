import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // Appletと違う
// swingはawtじゃないのでrepaintで上書きされる
// http://www1.megaegg.ne.jp/~yasu/ProgrammerPage/graphics/Graphics%20Swing.html

public class drawCircleFrame extends JFrame implements ActionListener {
  public static void main(String args[]) { // Appletと違う
    drawCircleFrame frame = new drawCircleFrame();
    frame.setBounds(0, 0, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setTitle("sample");
    frame.setVisible(true);
  }

  JTextField box1;
  int a;

  drawCircleFrame() { // public void init()の代わり
    JPanel p = new JPanel(); // Appletの代わり
    this.add(p, BorderLayout.CENTER); // Containerの代わり
    box1 = new JTextField(5);
    p.add(box1);
    box1.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ae) { // ActionListener読んだらいる
    String str1 = box1.getText();
    a = Integer.parseInt(str1);
    clear();
    // repaint();

    Graphics g = getGraphics();
    g.drawOval(300 - a, 200 - a, 2 * a, 2 * a);
  }

  public void clear() {
    Graphics g = getGraphics();
    g.setColor(getBackground());
    g.fillRect(0, 0, 600, 400);
    g.dispose();
  }

  // public void paint(Graphics g) {
  //   g.drawOval(300 - a, 200 - a, 2 * a, 2 * a);
  // }
}
