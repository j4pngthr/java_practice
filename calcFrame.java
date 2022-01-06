import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // Appletと違う

public class calcFrame extends JFrame implements ActionListener {
  public static void main(String args[]) { // Appletと違う
    calcFrame frame = new calcFrame();
    frame.setBounds(100, 100, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("sample");
    frame.setVisible(true);
  }

  JTextField box1, box2, box3;
  JLabel lb1, lb2;
  JButton bt;

  calcFrame() { // public void init()の代わり
    JPanel p = new JPanel(); // Appletの代わり

    box1 = new JTextField(5);
    p.add(box1);
    box1.addActionListener(this);

    lb1 = new JLabel("+");
    p.add(lb1);

    box2 = new JTextField(5);
    p.add(box2);
    box2.addActionListener(this);

    lb2 = new JLabel("=");
    p.add(lb2);

    box3 = new JTextField(5);
    p.add(box3);
    box3.addActionListener(this);

    bt = new JButton("implement");
    bt.addActionListener(this);
    p.add(bt);

    Container contentPane = getContentPane(); // ないと何も表示されない
    contentPane.add(p, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent ae) { // ActionListener読んだらいる
    if (ae.getSource() == bt) {
      String str1 = box1.getText();
      int a = Integer.parseInt(str1);

      String str2 = box2.getText();
      int b = Integer.parseInt(str2);

      String str3 = Integer.toString(a + b);
      box3.setText(str3);
    }
  }
}
