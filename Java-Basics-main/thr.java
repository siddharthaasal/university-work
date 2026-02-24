package Java;
// class thr implements Runnable{

//     public void run() {
//       System.out.println(Thread.currentThread().getId()); // display running              thread //
//         }
//     public static void main(String[] ar){
//     thr t=new thr();
//     Thread t1=new Thread(t);
//     t1.start();
//     }}

class thr extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }

    public static void main(String[] ar) {
        thr t = new thr();
        t.start();
    }
}
