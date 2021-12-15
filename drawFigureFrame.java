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

  public void paintLabel() {
    if (shape_id == 1) {
      lb1.setText("triangle");
    } else if (shape_id == 2) {
      lb1.setText("square");
    } else {
      lb1.setText("circle");
    }
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
    paintLabel();
  }
}
