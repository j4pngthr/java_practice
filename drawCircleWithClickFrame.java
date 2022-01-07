import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class drawCircleWithClickFrame extends JFrame implements MouseListener {
  int x, y;

  public static void main(String[] args) {
    drawCircleWithClickFrame frame = new drawCircleWithClickFrame();

    frame.setBounds(0, 0, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  drawCircleWithClickFrame() {
    JPanel p = new JPanel();
    p.addMouseListener(this);
    this.add(p, BorderLayout.CENTER); // Containerの代わり
  }

  public void clear() {
    Graphics g = getGraphics();
    g.setColor(getBackground());
    g.fillRect(0, 0, 600, 400);
    g.dispose();
  }

  public void paint(Graphics g) {
    Random r = new Random();

    g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
    // g.drawOval(x - 100, y - 100, 200, 200);
    for (int i = 0; i < 50; ++i) {
      g.drawOval(x - i, y - i, 2 * i, 2 * i);
    }
  }

  @Override public void mouseClicked(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    clear();
    repaint();
  }

  @Override public void mousePressed(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    clear();
    repaint();
  }

  @Override public void mouseReleased(MouseEvent e) {

  }

  @Override public void mouseEntered(MouseEvent e) {

  }

  @Override public void mouseExited(MouseEvent e) {

  }
}
