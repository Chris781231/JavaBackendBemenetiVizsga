package pokebag.pokemon;

public abstract class Pokemon {

    protected int health = 10;
    protected int strength;
    protected String name;

    protected Pokemon() {
    }

    protected Pokemon(String name) {
        this.name = name;
    }

    public abstract String speak();

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public void wounded() {
        health--;
    }
}
