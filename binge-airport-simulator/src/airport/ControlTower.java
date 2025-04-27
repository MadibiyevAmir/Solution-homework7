package airport;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private List<Aircraft> allAircraft = new ArrayList<>();
    private boolean runwayFree = true;

    public void registerAircraft(Aircraft a) {
        allAircraft.add(a);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println("[Broadcast] From " + sender.getId() + ": " + msg);

        if (msg.equalsIgnoreCase("MAYDAY")) {
            System.out.println("** EMERGENCY ** Clearing runway for " + sender.getId());
            landingQueue.addFirst(sender); // emergency gets first
            runwayFree = true;
            for (Aircraft a : allAircraft) {
                if (!a.equals(sender)) {
                    a.receive("Hold position. Emergency in progress.");
                }
            }
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (a.getFuelLevel() < 10) {
            System.out.println(a.getId() + " low fuel! Prioritizing landing.");
            landingQueue.addFirst(a);
        } else if (Math.random() < 0.5) { // случайно — запрос на посадку или взлёт
            System.out.println(a.getId() + " requests to land.");
            landingQueue.add(a);
        } else {
            System.out.println(a.getId() + " requests to take off.");
            takeoffQueue.add(a);
        }
        return true;
    }

    public void grantRunwayAccess() {
        if (!runwayFree) {
            System.out.println("Runway busy...");
            return;
        }

        Aircraft next = null;
        if (!landingQueue.isEmpty()) {
            next = landingQueue.poll();
        } else if (!takeoffQueue.isEmpty()) {
            next = takeoffQueue.poll();
        }

        if (next != null) {
            System.out.println("Runway cleared for " + next.getId());
            next.receive("You are cleared for runway!");
            runwayFree = false;
        }
    }

    public void releaseRunway() {
        runwayFree = true;
    }
}
