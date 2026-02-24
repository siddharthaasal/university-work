package Java;

public class GarbageBasics {
    public void finalize(){System.out.println("object is garbage collected");} 
 public static void main(String args[]){
 GarbageBasics s1=new GarbageBasics(); 
 GarbageBasics s2=new GarbageBasics(); 
 s1=null; 
 s2=null; 
 System.gc(); } 
}

