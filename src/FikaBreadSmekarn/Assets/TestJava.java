package FikaBreadSmekarn.Assets;

import java.util.Timer;
import java.util.TimerTask;

class TestJava {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Print in every second");
            }
        }, 0, 1000);//wait 0 milliseconds before doing the action and do it every 1000ms (1 second)
    }
}