package Java;
import java.util.*;
public class TryCatch {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String arr[] = new String[6];
        int idx = 0;
        try{
            for(int i=0; i<4; i++){
                System.out.print("Enter name of "+(i+1)+" student: ");
                arr[idx] =  kb.next();
                idx++;
                System.out.print("Enter UID of "+(i+1)+" student: ");
                arr[idx] =  kb.next();
                idx++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: You are accessing invalid array index");
        }
        idx = 0;
        for(int i=0; i<3;i++){
            System.out.println("Name of "+(i+1)+" student: "+arr[idx]);
            idx++;
            System.out.println("UID of "+(i+1)+" student: "+arr[idx]);
            idx++;
        }
    }
}

