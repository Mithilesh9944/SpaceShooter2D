package levels;

import entities.Bullet;

import java.awt.*;
import java.util.ArrayList;

public class BulletsManager {
    private ArrayList<Bullet> bullets;

    BulletsManager() {
        bullets = new ArrayList<>();
    }

    public void update() {
        // updating position of bullets
        for (int i=0;i<bullets.size();i++) {
            if (bullets.get(i).getY() > 0)
                bullets.get(i).update();
            else {
                bullets.remove(i);
            }
        }
    }

    public void render(Graphics g) {
        // rendering bullets
        for (int i=0;i<bullets.size();i++) {
            bullets.get(i).render(g);
        }
    }

    public void addBullet(float x, float y) {
        Bullet tmp = new Bullet(x, y, 0, 0);
        bullets.add(tmp);
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
