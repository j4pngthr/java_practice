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

  // 盤面の初期化
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

  // 石の情報を得た前提で，塗る
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

        if (field[i][j] == 0) g.setColor(new Color(0, 0, 0));
        else g.setColor(new Color(255, 255, 255));
        g.fillOval(j * 100 + 10, i * 100 + 10, 80, 80);
      }
    }
  }

  @Override public void mouseClicked(MouseEvent e) {

  }

  // 毎回の操作
  @Override public void mousePressed(MouseEvent e) {
    int y = e.getY();
    int x = e.getX();
    // 線ギリギリへのクリックじゃないか
    int fieldId = getFieldId(y, x);
    if (fieldId == -1) return;

    // ルールに基づいて碁石を置けるか
    y = fieldId / 8;
    x = fieldId % 8;

    if (!canSet()) playerId ^= 1;
    boolean ok = isValidSet(y, x, 1);

    clear();
    repaint();
    if (ok == true) playerId ^= 1;
  }

  @Override public void mouseReleased(MouseEvent e) {

  }

  @Override public void mouseEntered(MouseEvent e) {

  }

  @Override public void mouseExited(MouseEvent e) {

  }

  public int getFieldId(int y, int x) {
    for (int i = 0; i < 8; ++i) {
      for (int j = 0; j < 8; ++j) {
        if (100 * i + 10 < y && y < 100 * (i + 1) - 10 && 100 * j + 10 < x && x < 100 * (j + 1) - 10) {
          return i * 8 + j;
        }
      }
    }
    return -1;
  }

  // key: fieldを変えるか
  public boolean isValidSet(int y, int x, int key) {
    if (field[y][x] != -1) return false;
    boolean ret = false;

    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    for (int c = 0; c < 8; ++c) {
      for (int a = 2; a < 8; ++a) {
        int i = y + dy[c] * a;
        int j = x + dx[c] * a;
        if (i < 0 || j < 0 || i >= 8 || j >= 8) break;

        if (field[i][j] == playerId) {
          int flg = 0;
          for (int b = 1; b < a; ++b) {
            i = y + dy[c] * b;
            j = x + dx[c] * b;
            if (field[i][j] != (playerId ^ 1)) {
              flg = 1;
              break;
            }
          }
          if (flg == 1) break;
          // fieldの値を設定
          ret = true;
          if (key == 1) {
            for (int b = 0; b <= a; ++b) {
              i = y + dy[c] * b;
              j = x + dx[c] * b;
              field[i][j] = playerId;
            }
          }
          break;
        }
      }
    }

    return ret;
  }

  public boolean canSet() {
    for (int i = 0; i < 8; ++i) {
      for (int j = 0; j < 8; ++j) {
        if (isValidSet(i, j, 0)) return true;
      }
    }
    return false;
  }
}
