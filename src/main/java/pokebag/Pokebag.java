package pokebag;

import pokebag.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Pokebag {

    private List<Pokemon> pokemons = new ArrayList<>();

    public void add(Pokemon pokemon) {
        if (pokemon == null) throw new IllegalArgumentException("pokemon is null");
        pokemons.add(pokemon);
    }

    public int getNumberOfPokemons() {
        return pokemons.size();
    }

    public Pokemon getStrongest() {
        return pokemons.stream()
                .max(Comparator.comparingInt(Pokemon::getStrength)).orElseThrow(NoSuchElementException::new);
    }

    public Pokemon getByIndex(int index) {
        return pokemons.get(index);
    }

    public Pokemon fight(int index1, int index2) {
        if (index1 == index2) throw new IllegalArgumentException("invalid params");

        Pokemon stronger;
        Pokemon weaker;

        if (pokemons.get(index1).getStrength() >= pokemons.get(index2).getStrength()) {
            stronger = pokemons.get(index1);
            weaker = pokemons.get(index2);
        } else {
            stronger = pokemons.get(index2);
            weaker = pokemons.get(index1);
        }

        weaker.wounded();
        System.out.println(stronger.speak());

        return stronger;
    }
}
