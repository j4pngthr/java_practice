import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalculatorFrame extends JFrame implements ActionListener {
  public static void main(String[] args) {
    CalculatorFrame frame = new CalculatorFrame();

    frame.setBounds(0, 0, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("sample");
    frame.setVisible(true);
  }

  JTextField box, box2;
  JButton bt;

  CalculatorFrame() {
    JPanel p = new JPanel();

    box = new JTextField(20);
    box.addActionListener(this);
    p.add(box);

    bt = new JButton("Go");
    bt.addActionListener(this);
    p.add(bt);

    box2 = new JTextField(5);
    box2.addActionListener(this);
    p.add(box2);

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }

  int ans = 0, cur = 0;

  public void actionPerformed(ActionEvent ae) { // ActionListener読んだらいる
    String str = box.getText();
    char[] cs = str.toCharArray();
    char bef_opr = '+';

    for (int i = 0; i < cs.length; ++i) {
      char c = cs[i];
      if (c == '+'|| c == '-' || c == '*' || c == '/') {
        if (bef_opr == '+') ans += cur;
        else if (bef_opr == '-') ans -= cur;
        else if (bef_opr == '*') ans *= cur;
        else if (bef_opr == '/') ans /= cur;
        cur = 0;

        bef_opr = c;
      } else if ('0' <= c && c <= '9') {
        int num = c - '0';
        if (i != 0 && '0' <= cs[i - 1] && cs[i - 1] <= '9') {
          cur *= 10;
        }
        cur += num;
      }
    }

    if (ae.getSource() == bt) {
      if (bef_opr == '+') ans += cur;
      else if (bef_opr == '-') ans -= cur;
      else if (bef_opr == '*') ans *= cur;
      else if (bef_opr == '/') ans /= cur;
      cur = 0;
      bef_opr = '+';

      String _ans = Integer.toString(ans);
      box2.setText(_ans);
      ans = 0;
    }
  }
}
