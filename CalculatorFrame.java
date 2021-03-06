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

  char cs[];
  public void actionPerformed(ActionEvent ae) { // ActionListener読んだらいる
    String str = box.getText();
    if (str.substring(0, 1) == "-") str = '0' + str;
    cs = str.toCharArray();

    if (ae.getSource() == bt) {
      itr = 0;
      String ans = Double.toString(expr());
      box2.setText(ans);
    }
  }

  int itr = 0;

  double expr() {
    double ret = term();
    while(true) {
      if (itr >= cs.length) break;

      char c = cs[itr];
      if (c == '+') {
        ++itr; // 数字を読む
        ret += term();
      } else if (c == '-') {
        ++itr;
        ret -= term();
      } else {
        break;
      }
    }
    return ret;
  }

  double term() {
    double ret = factor();
    while(true) {
      if (itr >= cs.length) break;

      char c = cs[itr];
      if (c == '*') {
        ++itr;
        ret *= factor();
      } else if (c == '/') {
        ++itr;
        ret /= factor();
      } else if (c == '^') {
        ++itr;
        ret = Math.pow(ret, factor());
      } else {
        break;
      }
    }
    return ret;
  }

  double factor() {
    double ret = 0;

    char c = cs[itr];
    if (c == '(' || c == ')') {
      ++itr; // '('の次
      ret = expr();
      ++itr; // ')'の次
    } else if (c >= '0' && c <= '9') {
      ret = c - '0';
      String str = "";
      str += c;

      while (true) {
        ++itr;
        if (itr >= cs.length) break;

        c = cs[itr];
        if (c >= '0' && c <= '9') {
          ret *= 10;
          ret += c - '0';
        } else if (c == '.') {

        } else {
          break;
        }
        str += c;
      }

      char[] cs = str.toCharArray();
      for (int i = 0; i < cs.length; ++i) {
        if (cs[i] == '.') {
          ret /= Math.pow(10, cs.length - i - 1);
          break;
        }
      }
    } else {

    }
    return ret;
  }
}
