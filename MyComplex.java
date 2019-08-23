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

    public double magnitude() {
        return Math.sqrt((this.real * this.real) + (this.imag * this.imag));
    }

    public double argument() {
        return Math.atan(this.imag / this.real);
    }

    public MyComplex add(MyComplex rigth) {
        this.setReal(this.real + rigth.getReal());
        this.setImag(this.imag + rigth.getImag());
        return this;
    }

    public MyComplex addNew(MyComplex rigth) {
        MyComplex newComplex = new MyComplex(this.real + rigth.getReal(), this.imag + rigth.getImag());
        return newComplex;
    }

    public MyComplex subtract(MyComplex right) {
        this.setReal(this.real - right.getReal());
        this.setImag(this.imag - right.getImag());
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        MyComplex newComplex = new MyComplex(this.real - right.getReal(), this.imag - right.getImag());
        return newComplex;
    }

    public MyComplex multiply(MyComplex right) {
        this.setValue((this.real * right.getReal() - this.imag * right.getImag()), (this.real * right.getImag() + this.imag * right.getReal()));
        return this;
    }

    private MyComplex multiply(double imag) {
        return new MyComplex(this.real * imag, this.imag * imag);
    }

    public MyComplex conjucate() {
        return new MyComplex(real, -imag);
    }

    public MyComplex divide(MyComplex right) {
        double imag = 1 / (right.getReal() * right.getReal() + right.getImag() * right.getImag());  // + за счёт мнимой единицы
        return this.multiply(right.conjucate()).multiply(imag);
    }
}
