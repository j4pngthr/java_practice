import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // Appletと違う
import java.awt.Color;
import java.awt.Graphics;

public class othelloFrame extends JFrame implements MouseListener {
  int playerId = 0;
  int field[][] = new int[8][8];

  public static void main(String args[]) { // Appletと違う
    othelloFrame frame = new othelloFrame();
    frame.setBounds(0, 0, 800, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  othelloFrame() { // public void init()の代わり
    JPanel p = new JPanel(); // Appletの代わり
    p.addMouseListener(this);

    Container contentPane = getContentPane();
    contentPane.setBackground(new Color(0, 84, 56));
    contentPane.add(p, BorderLayout.CENTER);

    for (int i = 0; i < 8; ++i) {
      for (int j = 0; j < 8; ++j) {
        field[i][j] = -1;
      }
    }
    field[3][3] = 0;
    field[4][3] = 1;
    field[3][4] = 1;
    field[4][4] = 0;
  }

  public void clear() {
    Graphics g = getGraphics();
    g.setColor(new Color(0, 84, 56));
    g.fillRect(0, 0, 800, 800);
    g.dispose();
  }

  public void paint(Graphics g) {
    for (int i = 1; i < 8; ++i) {
      g.drawLine(0, 100 * i, 800, 100 * i);
    }
    for (int j = 1; j < 8; ++j) {
      g.drawLine(100 * j, 0, 100 * j, 800);
    }

    for (int i = 0; i < 8; ++i) {
      for (int j = 0; j < 8; ++j) {
        if (field[i][j] == -1) continue;

        int y = i - i % 100;
        int x = j - j % 100;
        if (field[i][j] == 0) g.setColor(new Color(0, 0, 0));
        else g.setColor(new Color(255, 255, 255));
        g.fillOval(i * 100 + 10, j * 100 + 10, 80, 80);
      }
    }
  }

  @Override public void mouseClicked(MouseEvent e) {

  }

  @Override public void mousePressed(MouseEvent e) {
    int fieldId = getFieldId(e.getX(), e.getY());
    if (fieldId == -1) return;
    playerId ^= 1;

    clear();
    repaint();
  }

  @Override public void mouseReleased(MouseEvent e) {

  }

  @Override public void mouseEntered(MouseEvent e) {

  }

  @Override public void mouseExited(MouseEvent e) {

  }

  public int getFieldId(int x, int y) {
    for (int i = 0; i < 8; ++i) {
      for (int j = 0; j < 8; ++j) {
        if (100 * i + 10 < y && y < 100 * (i + 1) - 10 && 100 * j + 10 < x && x < 100 * (j + 1) - 10) {
          return i * 8 + j;
        }
      }
    }
    return -1;
  }
}
