package commands;

import java.util.List;

public class CreateCityList implements Command {
    private final List<String> cities;

    public CreateCityList(final List<String> cities) {
        this.cities = cities;
    }

    /**
     *
     */
    @Override
    public void execute() {
        cities.add("Bucuresti");
        cities.add("Constanta");
        cities.add("Buzau");
        cities.add("Timisoara");
        cities.add("Cluj-Napoca");
        cities.add("Iasi");
        cities.add("Craiova");
        cities.add("Brasov");
        cities.add("Braila");
        cities.add("Oradea");
    }
}
