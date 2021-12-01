import java.io.*;

public class Hito {
  public static void main(String[] args) throws IOException {
    Circle c = new Circle();

    System.out.println("半径の値を入力してください．");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int r = Integer.parseInt(str);
    c.setR(r);

    System.out.println("面積は，" + c.calcArea() + "です．");
    System.out.println("円周は，" + c.calcCircuit() + "です．");
  }
}

class Circle {
  int r;
  double calcArea() {
    return Math.PI * r * r;
  }
  double calcCircuit() {
    return 2 * Math.PI * r;
  }
  void setR(int r) {
    this.r = r;
  }
}
