/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/3 10:09
 * @Version 1.0
 */

public class demo9 {
    public static void main(String[] args) {
        Thread t1 = new Thread( () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("hello thread1");
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //t1.start();
        t1.run();
        for(int i = 0 ; i < 5 ; i++){
            System.out.println("hello main");
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
