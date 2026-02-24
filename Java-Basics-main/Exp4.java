package Java;

class Rectangle {
    double width, length, area;
    String color;

    void set_width(double val) {
        width = val;
    }

    void set_length(double val) {
        length = val;
    }

    void set_color(String val) {
        color = val;
    }

    void find_area() {
        area = length * width;
    }

    double get_area() {
        area = length * width;
        return area;
    }

    String get_color() {
        return color;
    }
}

public class Exp4 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        r1.set_width(2);
        r1.set_length(3);
        r1.set_color("Red");
        r2.set_width(3);
        r2.set_length(2);
        r2.set_color("Red");

        String color1 = r1.get_color();
        String color2 = r2.get_color();
        double area1 = r1.get_area();
        double area2 = r2.get_area();

        if (color1.equals(color2) && area1 == area2) {
            System.out.println("Matching Rec");
        } else {
            System.out.println("Non Matching Rec");
        }
    }
}
