package jzl.com.crackcodeinterview.H;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * jzl.com.crackcodeinterview.H
 * Created by kingj on 2020/7/15 0015.
 * 8. 6 　 汉 诺 塔 问题。
 */
public class H6 {

    public static void main(String[] args) {
        new H6().movePlate(5);
    }

    private class Tower {
        ArrayList<Integer> list = new ArrayList<>();
        int id;

        Tower(int id) {
            this.id = id;
        }
    }

    private Tower[] towers = new Tower[]{new Tower(1), new Tower(2), new Tower(3)};

    public void movePlate(int n) {
        for (int i = n; i >= 1; i--) {
            towers[0].list.add(i);
        }
        if (n == 1) {
            movePlate(n, 0, 2);
        } else {
            movePlate(n - 1, 0, 1, 2);
            movePlate(n, 0, 2);
            movePlate(n - 1, 1, 2, 0);
        }
        System.out.println(towers[0].list.toString());
        System.out.println(towers[1].list.toString());
        System.out.println(towers[2].list.toString());
    }

    private void movePlate(int n, int currentTower, int targetTower, int bufferTower) {
        if (n == 1) {
            movePlate(n, currentTower, targetTower);
            return;
        }
        movePlate(n - 1, currentTower, bufferTower, targetTower);
        movePlate(n, currentTower, targetTower);
        movePlate(n - 1, bufferTower, targetTower, currentTower);
    }

    private void movePlate(int n, int currentTower, int targetTower) {
        System.out.println("plate " + n + " from tower " + currentTower + " to tower " + targetTower);
        towers[currentTower].list.remove(Integer.valueOf(n));
        towers[targetTower].list.add(n);
    }
}
