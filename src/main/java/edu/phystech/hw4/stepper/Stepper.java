package edu.phystech.hw4.stepper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kzlv4natoly
 */

public class Stepper {

    public enum Side {
        LEFT, RIGHT
    }

    private final List<Side> history = new ArrayList<>();
    private final Object lock = new Object();
    private boolean isLeftTurn = true;

    public synchronized void leftStep() throws InterruptedException {
        while (!isLeftTurn) {
            wait();
        }
        history.add(Side.LEFT);
        isLeftTurn = false;
        notifyAll();
    }

    public synchronized void rightStep() throws InterruptedException {
        while (isLeftTurn) {
            wait();
        }
        history.add(Side.RIGHT);
        isLeftTurn = true;
        notifyAll();
    }

    public List<Side> getHistory() {
        return history;
    }
}
