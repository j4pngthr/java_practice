import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // Appletと違う

public class countUpFrame extends JFrame implements Runnable {
  int num, x;
  JLabel lb1;

  public static void main(String args[]) { // Appletと違う
    countUpFrame frame = new countUpFrame();
    frame.setBounds(0, 0, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setTitle("sample");
    frame.setVisible(true);
  }

  countUpFrame() { // public void init()の代わり
    JPanel p = new JPanel(); // Appletの代わり

    lb1 = new JLabel("");
    p.add(lb1);

    this.add(p, BorderLayout.CENTER); // Containerの代わり

    new Thread(this).start();
  }

  public void run() {
    try {
      for (num = 0; num < 100; ++num) {
        lb1.setText("ThreadCouter: " + Integer.toString(num));
        Thread.sleep(1000);
      }
    } catch(InterruptedException e) {}
  }
}
