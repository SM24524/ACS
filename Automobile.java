interface Vehicle{
    public String color();
    public int axles();
    public int vin();
    public int year();

}

class Car implements Vehicle{
    String color;
    int axles;
    int vin;
    int year;
    double mileage;
    int cups;

    public Car(String c, int a, int v, int y, double m, int cup){
        color = c;
        axles = a;
        vin = v;
        year = y;
        mileage = m;
        cups = cup;
    }

    public String color(){
        return color;
    }

    public int axles(){
        return axles;
    }

    public int vin(){
        return vin;
    }

    public int year(){
        return year;
    }

    public float mileage(){
        return (float) mileage;
    }

    public int cups(){
        return cups;
    }
}


class Truck implements Vehicle{
    String color;
    int axles;
    int vin;
    int year;
    double horsepower;
    boolean plow;

    public Truck(String c, int a, int v, int y, double hp, boolean p){
        color = c;
        axles = a;
        vin = v;
        year = y;
        horsepower = hp;
        plow = p;
    }

    public String color(){
        return color;
    }

    public int axles(){
        return axles;
    }

    public int vin(){
        return vin;
    }

    public int year(){
        return year;
    }

    public float horsepower(){
        return (float) horsepower;
    }

    public boolean plow(){
        return plow;
    }
}



public class Automobile {
    public static void main(String[] args){
        System.out.println("hi");
        Car corolla = new Car("Blue", 2, 35, 2005, 25, 2);
        System.out.println(corolla.color());
        Truck chevy = new Truck("Red", 4, 42, 2010, 250, true);
        System.out.println(chevy.plow());
   }
}
