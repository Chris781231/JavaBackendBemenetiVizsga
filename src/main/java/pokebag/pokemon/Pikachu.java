package pokebag.pokemon;

public class Pikachu extends Pokemon {

    public Pikachu() {
        super();
        this.strength = 10;
        this.name = "Pikachu";
    }

    public Pikachu(String name) {
        super(name);
        this.strength = 10;
    }

    @Override
    public String speak() {
        return "Pika-pika";
    }
}
