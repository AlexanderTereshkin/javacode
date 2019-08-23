package part2;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return this.real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return this.imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "((" + real +
                ") + (" + imag +
                "i))";
    }

    public boolean isReal() {
        return (this.real != 0);
    }

    public boolean isImaginary() {
        return (this.imag != 0);
    }

    public boolean equals(double real, double imag) {
        return (real == imag);
    }

    public boolean equals(MyComplex another) {
        return ((this.real == another.getReal()) && (this.imag == another.getImag()));
    }

    // Return module of complex number
    public double magnitude() {
        return Math.sqrt((this.real * this.real) + (this.imag * this.imag));
    }

    // In radians
    public double argument() {
        return Math.atan(this.imag / this.real);
    }

    // Return "this" object after addition (this does`t make some new object)
    public MyComplex add(MyComplex rigth) {
        this.setReal(this.real + rigth.getReal());
        this.setImag(this.imag + rigth.getImag());
        return this;
    }

    // Return new object after addition
    public MyComplex addNew(MyComplex rigth) {
        MyComplex newComplex = new MyComplex(this.real + rigth.getReal(), this.imag + rigth.getImag());
        return newComplex;
    }

    // Return "this" object after subtract (this does`t make some new object)
    public MyComplex subtract(MyComplex right) {
        this.setReal(this.real - right.getReal());
        this.setImag(this.imag - right.getImag());
        return this;
    }

    // Return new object after subtract
    public MyComplex subtractNew(MyComplex right) {
        MyComplex newComplex = new MyComplex(this.real - right.getReal(), this.imag - right.getImag());
        return newComplex;
    }

    // Return "this" object after multiply (this does`t make some new object)
    public MyComplex multiply(MyComplex right) {
        this.setValue((this.real * right.getReal() - this.imag * right.getImag()), (this.real * right.getImag() + this.imag * right.getReal()));
        return this;
    }

    // Return new object after multiply
    public MyComplex multiplyNew(MyComplex right) {
        MyComplex newComplex = new MyComplex((this.real * right.getReal() - this.imag * right.getImag()), (this.real * right.getImag() + this.imag * right.getReal()));
        return newComplex;
    }

    // Private multiply method for divide method. Real and imaginary parts multiplies to imag (which calculated in divide method) separatly.
    private MyComplex multiply(double imag) {
        return new MyComplex(this.real * imag, this.imag * imag);
    }

    // Make conjucate complex number (new object) of denominator (Use this method for divide method)
    public MyComplex conjucate() {
        return new MyComplex(real, -imag);
    }

    // Return "this" object after divide (this does`t make some new object)
    public MyComplex divide(MyComplex right) {
        double imag = 1 / (right.getReal() * right.getReal() + right.getImag() * right.getImag());
        return this.multiply(right.conjucate()).multiply(imag);
    }

    // Return new object after divide
    public MyComplex divideNew(MyComplex right) {
        double imag = 1 / (right.getReal() * right.getReal() + right.getImag() * right.getImag());
        MyComplex newComplex = this.multiplyNew(right.conjucate()).multiply(imag);
        return newComplex;
    }
}
