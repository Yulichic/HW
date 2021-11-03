package com.company;

public class Main {

    import java.util.Objects;

    public class Rectangle {
        private float a;
        private float b;
        private int hashCodeRectangle = 0;

        public Rectangle() {
            this.a = 0;
            this.b = 0;
        }
        public Rectangle(float a, float b) {
            if(a < 0) {
                System.out.println("Incorret a");
                this.a = 0;
            }else {
                this.a = a;
            }
            if(b < 0) {
                System.out.println("Incorret b");
                this.b = 0;
            } else {
                this.b = b;
            }
        }

        public float getA() {
            return a;
        }

        public void setA(float a) {
            if(a < 0) {
                System.out.println("Incorret a");
                this.a = 0;
            } else {
                this.a = a;
            }
        }

        public float getB() {
            return b;
        }

        public void setB(float b) {
            if(b < 0) {
                System.out.println("Incorret b");
                this.b = 0;
            } else {
                this.b = b;
            }
        }

        @Override
        public String toString() {
            return "Rectangle(" + "a = " + a + ", b = " + b + ')';
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Rectangle r)) return false;

            return (this.a == r.a && this.b == r.b);
        }

        @Override
        public int hashCode() {
            ++hashCodeRectangle;
            return hashCodeRectangle + 10;
        }

        public float area() {
            return a*b;
        }

        public float perimeter() {
            return 2*(a+b);
        }
    }

    public static void main(String[] args) {

    }
}
