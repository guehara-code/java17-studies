package dev.lpa.pirate;

import java.util.*;

public final class Pirate extends Combatant {

    private final List<Town> townsVisited = new LinkedList<Town>();

    private List<Loot> loot;
    private List<Combatant> opponents;
    private List<Feature> features;

    public Pirate(String name) {
        super(name, Map.of("level", 0, "townIndex", 0));
        visitTown();
    }


    boolean useWeapon() {

        System.out.println("Used the " + super.getCurrentWeapon());
        return visitNextTown();
    }

    boolean visitTown() {

        List<Town> levelTowns = PirateGame.getTowns(value("level"));
        if (levelTowns == null) return true;
        Town town = levelTowns.get(value("townIndex"));
        if (town != null) {
            townsVisited.add(town);
            return false;
        }
        return true;
    }




    public String information() {

        var current = ((LinkedList<Town>) townsVisited).getLast();
        String[] simpleNames = new String[townsVisited.size()];
        Arrays.setAll(simpleNames, i -> townsVisited.get(i).name());
        return "---> " + current +
                "\n" + super.information() +
                "\n\ttownsVisited=" + Arrays.toString(simpleNames);
    }

    private boolean visitNextTown() {

        int townIndex = value("townIndex");
        List<Town> towns = PirateGame.getTowns(value("level"));
        if (towns == null) return true;
        if (townIndex >= (towns.size() - 1)) {
            System.out.println("Leveling up! Bonus: 500 points!");
            adjustValue("score", 500);
            adjustValue("level", 1);
            setValue("townIndex", 0);
        } else {
            System.out.println("Sailing to next town! Bonus: 50 points!");
            adjustValue("townIndex", 1);
            adjustValue("score", 50);
        }
        return visitTown();
    }
}
