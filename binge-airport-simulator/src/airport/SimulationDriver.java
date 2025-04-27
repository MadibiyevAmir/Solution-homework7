package airport;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class SimulationDriver {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        Random rand = new Random();

        Aircraft[] planes = new Aircraft[10];
        for (int i = 0; i < 10; i++) {
            int type = rand.nextInt(3);
            String id = "AC" + (i + 1);
            int fuel = rand.nextInt(100);

            if (type == 0) {
                planes[i] = new PassengerPlane(id, fuel);
            } else if (type == 1) {
                planes[i] = new CargoPlane(id, fuel);
            } else {
                planes[i] = new Helicopter(id, fuel);
            }
            tower.registerAircraft(planes[i]);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() -> {
            int idx = rand.nextInt(planes.length);
            Aircraft a = planes[idx];

            if (a.getFuelLevel() < 5) {
                a.send("MAYDAY", tower);
            } else {
                tower.requestRunway(a);
            }
            tower.grantRunwayAccess();
        }, 0, 2, TimeUnit.SECONDS);
    }
}
