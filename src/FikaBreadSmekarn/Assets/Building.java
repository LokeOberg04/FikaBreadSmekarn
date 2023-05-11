package FikaBreadSmekarn.Assets;

public class Building {
        int fps;
        int cost;
        int owned;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }

    public Building(int fps, int cost) {
        this.fps = fps;
        this.cost = cost;
        this.owned = 0;
    }
}
