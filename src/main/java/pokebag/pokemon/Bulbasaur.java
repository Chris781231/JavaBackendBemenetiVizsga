package pokebag.pokemon;

public class Bulbasaur extends Pokemon{

    public Bulbasaur() {
        super();
        this.strength = 6;
        this.name = "Bulbasaur";
    }

    public Bulbasaur(String name) {
        super(name);
        this.strength = 6;
    }

    @Override
    public String speak() {
        return "Bulba-saur";
    }
}
