import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class drawFigureFrame extends JFrame implements ActionListener {
  int i = 0;
  JButton bt1, bt2, bt3;
  JLabel lb1;
  int shape_id;

  public static void main(String[] args) {
    drawFigureFrame frame = new drawFigureFrame();

    frame.setBounds(100, 100, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("sample of push button");
    frame.setVisible(true);
  }

  drawFigureFrame() {
    JPanel p = new JPanel();
    bt1 = new JButton("triangle");
    bt2 = new JButton("square");
    bt3 = new JButton("circle");


    lb1 = new JLabel("");
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    bt3.addActionListener(this);

    p.add(bt1);
    p.add(bt2);
    p.add(bt3);

    p.add(lb1);
    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }

  public void paint(Graphics g) {
    if (shape_id == 1) {
      g.setColor(new Color(0, 0, 255));
      int x[] = { (400 + 100) / 2, 100, 400 }; // この3点で三角形
      int y[] = { 100, 400, 400 };
      g.fillPolygon(x, y, 3);
    } else if (shape_id == 2) {
      g.setColor(new Color(0, 255, 0));
      g.fillRect(100, 100, 300, 300);
    } else {
      g.setColor(new Color(255, 0, 0));
      g.drawOval(100, 100, 300, 300); // 円を描く, x, y, width, height
    }
  }

  public void clear() {
    Graphics g = getGraphics();
    g.setColor(getBackground());
    g.fillRect(0, 99, 600, 301);
    g.dispose();
  }

  public void actionPerformed(ActionEvent ae) {
    System.out.println(i);
    ++i;
    if (ae.getSource() == bt1) {
      shape_id = 1;
    } else if (ae.getSource() == bt2) {
      shape_id = 2;
    } else {
      shape_id = 3;
    }
    clear();
    repaint();
  }
}

// http://www.ibe.kagoshima-u.ac.jp/edu/ProgramingJava/Event/s2.html
// https://ja.stackoverflow.com/questions/20962/repaint%e3%81%97%e3%81%a6%e3%82%82paintcomponent%e3%81%8c%e5%91%bc%e3%81%b0%e3%82%8c%e3%81%aa%e3%81%84
