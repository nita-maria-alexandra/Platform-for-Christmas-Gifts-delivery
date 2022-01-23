package commands;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

import data.ChildInputData;

public class AverageCityCommand implements Command {
    private LinkedHashMap<String, Double> niceScoreCity;
    private final List<ChildInputData> childInputData;
    private final List<String> cities;

    public AverageCityCommand(final LinkedHashMap<String, Double> niceScoreCity,
                              final List<ChildInputData> childInputData,
                              final List<String> cities) {
        this.niceScoreCity = niceScoreCity;
        this.childInputData = childInputData;
        this.cities = cities;
    }

    /**
     *
     * Returneaza media aritmetica a averageScore-urilor copiilor
     * care se afla in orasul @city
     */
    public Double getNiceScoreCity(final String city) {
        double sum = 0.0;
        int nr = 0;

        for (ChildInputData child:childInputData) {
            if (child.getAge() <= common.Constants.EIGHTEEN
                    && child.getCity().compareTo(city) == 0) {
                nr++;
                sum += child.getAverageScore();
            }
        }

        if (nr != 0) {
            sum = sum / nr;
            return sum;
        }

        return -1.0;
    }

    /**
     * Adauga in niceScoreCity orasele si media corespunzatoare
     * fiecarui oras, in ordine descrescatoare
     */
    @Override
    public void execute() {
        double niceScore;
        Map<String, Double> map = new java.util.HashMap<>();
        SortedMap<String, Double> niceScoreCity2 = new TreeMap<>((o1, o2) -> {
            if (Double.compare(map.get(o1), map.get(o2)) == 0) {
                return o1.compareTo(o2);
            }

            return Double.compare(map.get(o2), map.get(o1));
        });

        for (String city:cities) {
            niceScore = getNiceScoreCity(city);
            if (Double.compare(niceScore, -1.0) != 0) {
                map.put(city, niceScore);
            }
        }

        niceScoreCity2.putAll(map);
        niceScoreCity.putAll(niceScoreCity2);
    }
}
