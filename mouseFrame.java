import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class mouseFrame extends JFrame implements MouseListener {
  int mode;

  public static void main(String[] args) {
    mouseFrame frame = new mouseFrame();

    frame.setBounds(0, 0, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("sample");
    frame.setVisible(true);
  }

  mouseFrame() {
    JPanel p = new JPanel();

    p.addMouseListener(this);

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }

  public void mouseClicked(MouseEvent e) {
    mode = 1;
    clear();
    repaint();
  }

  public void mousePressed(MouseEvent e) {
    mode = 2;
    clear();
    repaint();
  }

  public void mouseReleased(MouseEvent e) {
    mode = 3;
    clear();
    repaint();
  }

  public void mouseEntered(MouseEvent e) {
    mode = 4;
    clear();
    repaint();
  }

  public void mouseExited(MouseEvent e) {
    mode = 5;
    clear();
    repaint();
  }

  public void clear() {
    Graphics g = getGraphics();
    g.setColor(getBackground());
    g.fillRect(0, 0, 600, 400);
    g.dispose();
  }

  public void paint(Graphics g) {
    switch(mode) {
      case 1:
        g.drawString("クリックしました．", 100, 100);
        break;
      case 2:
        g.drawString("ボタンを押しています．", 100, 100);
        break;
      case 3:
        g.drawString("ボタンを離しました．", 100, 100);
        break;
      case 4:
        g.drawString("ウィンドウ内に入りました．", 100, 100);
        break;
      case 5:
        g.drawString("ウィンドウ外です．", 100, 100);
    }
  }

}
