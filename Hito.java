public class Hito {
  public static void main(String[] args) {
    Person p1 = new Person();

    p1.name = "name";
    p1.age = 20;

    p1.show();
  }
}

class Person {
  String name;
  int age;

  void show() { // クラスに入れたら使い回せる
    System.out.println("p1.name = " + name);
    System.out.println("p1.age = " + age);
  }
}
