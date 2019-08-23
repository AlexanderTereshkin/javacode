package part2;

public class Task1 {
    public static void main(String[] args) {
        MyComplex mycomplex1 = new MyComplex(3,1);
        MyComplex mycomplex2 = new MyComplex(5,-2);
        System.out.println(mycomplex1.addNew(mycomplex2));
        System.out.println(mycomplex1.subtractNew(mycomplex2));
        System.out.println(mycomplex1.multiply(mycomplex2));
        System.out.println(mycomplex1.divide(mycomplex2));
    }
}
