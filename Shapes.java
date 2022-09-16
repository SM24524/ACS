interface shapeList{
    public double perimeter();
    public double area();
}

class Rectangle implements shapeList{

    double length;
    double width;

    public Rectangle(double l, double w){
    length = l;
    width = w;
    }


    public double perimeter(){
        return((2*length)+(2*width));
    }


    public double area() {
        return(length*width);
    }
}

class Circle implements shapeList{

    double radius;

    public Circle(double r){
        radius = r;
    }


    public double perimeter(){
        return(2*3.14*radius);
    }


    public double area() {
        return(3.14*radius*radius);
    }
}




public class Shapes {
    public static void main(String[]args) {
        System.out.println("hello");

        Rectangle test = new Rectangle(4.2, 3.2);
        System.out.println(test.perimeter());

        Circle c = new Circle(3.4);
        System.out.println(c.area());
    }
}
