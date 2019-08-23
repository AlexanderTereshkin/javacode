package part2;

public class Task1 {
    public static void main(String[] args) {
        MyComplex mycomplex1 = new MyComplex(3,1);
        MyComplex mycomplex2 = new MyComplex(5,-2);
        System.out.println("Complex number mycomplex1 " + mycomplex1);
        System.out.println("Complex number mycomplex2 " + mycomplex2);
        System.out.println("Result of addition " + mycomplex1 + " and " + mycomplex2 + " = " + mycomplex1.addNew(mycomplex2));
        System.out.println("Result of subtract " + mycomplex1 + " and " + mycomplex2 + " = " + mycomplex1.subtractNew(mycomplex2));
        System.out.println("Result of multiply " + mycomplex1 + " and " + mycomplex2 + " = " + mycomplex1.multiplyNew(mycomplex2));
        System.out.println("Result of divide " + mycomplex1 + " and " + mycomplex2 + " = " + mycomplex1.divideNew(mycomplex2));

        /**
         * Let`s check for divide of complex numbers.
         * If newMyComplex = mycomplex1 / mycomplex2
         * So mycomplex1 must be equals to newMyComplex2 = (newMyComplex * mycomplex2)
         */
        MyComplex newMyComplex = mycomplex1.divideNew(mycomplex2);
        MyComplex newMyComplex2 = newMyComplex.multiplyNew(mycomplex2);
        System.out.println("After multiply, this result of divide, with mycomplex2, we have: " + newMyComplex2);
        if (newMyComplex2.equals(mycomplex1)) {
            System.out.println("This is equal to mycomplex1 " + mycomplex1);
        } else {
            System.out.println("This is NOT equal to mycomplex1 " + mycomplex1);
        }
    }
}
