package StringList;

import java.util.ArrayList;
import java.util.List;

public class Array_List_work extends Thread {
    private static final ArrayList<String> array_list = new ArrayList<>();

    public Array_List_work() {
        start();
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        ArrayList<Thread> array_list_threads = new ArrayList<>();

        for(int ind_arr=0;ind_arr<60;ind_arr++){
            array_list_threads.add(new Array_List_work());
        }

        for (Thread thread: array_list_threads){
            try { thread.join();
        } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("It workes " +(System.currentTimeMillis()-time)/1000+ "c"+array_list.size());
    }

    @Override
    public void run() {
        //super.run();
        for (int index2 = 0; index2<100000; index2++){
            array_list.add("It workes "+index2);
            //System.out.println("It workes "+index2);
        }
    }
}
