package airport;

public abstract class Aircraft {
    protected String id;
    protected int fuelLevel; // топливо в процентах

    public Aircraft(String id, int fuelLevel) {
        this.id = id;
        this.fuelLevel = fuelLevel;
    }

    public String getId() {
        return id;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void send(String msg, TowerMediator tower) {
        tower.broadcast(msg, this);
    }

    public abstract void receive(String msg);
}
