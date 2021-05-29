package pokebag.pokemon;

public class Charmander extends Pokemon {

    public Charmander() {
        super();
        this.strength = 8;
        this.name = "Charmander";
    }

    public Charmander(String name) {
        super(name);
        this.strength = 8;
    }

    @Override
    public String speak() {
        return "Char-char";
    }
}

