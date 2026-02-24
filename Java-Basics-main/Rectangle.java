package Java;

public class Rectangle {

    //data fields
    double width, length, area;
    String color;
    
    //methods
    void set_width(double val){
        width = val;
    }
    void set_length(double val){
        length = val;
    }
    void set_color(String val){
        color = val;
    }
    double find_area(){
        return length*width;
    }
}
