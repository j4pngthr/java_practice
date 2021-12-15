import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class changeColorFrame extends JFrame implements ActionListener {
  int i = 0;
  JButton bt1, bt2;
  JLabel lb1;
  boolean flg;

  public static void main(String[] args) {
    changeColorFrame frame = new changeColorFrame();

    frame.setBounds(100, 100, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("sample of push button");
    frame.setVisible(true);
  }

  changeColorFrame() {
    JPanel p = new JPanel();
    bt1 = new JButton("blue");
    bt2 = new JButton("red");

    lb1 = new JLabel("");
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    p.add(bt1);
    p.add(bt2);
    p.add(lb1);
    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }

  public void paintLabel() {
    if (flg) lb1.setForeground(Color.BLUE);
    else lb1.setForeground(Color.RED);
    lb1.setText("Push button, and the color changes");
  }

  public void actionPerformed(ActionEvent ae) {
    System.out.println(i);
    ++i;
    if (ae.getSource() == bt1) {
      flg = true;
    } else if (ae.getSource() == bt2) {
      flg = false;
    }
    paintLabel();
  }
}
