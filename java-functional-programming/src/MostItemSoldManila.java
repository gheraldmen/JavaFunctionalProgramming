import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class MostItemSoldManila {
    public static void main(String[] args) throws IOException {
        Path davaoPath = Paths.get("sales/manila.csv");

        Stream<String> stream = Files.lines(davaoPath);
            List<List<String>> values = stream.map(line -> Arrays.asList(line.split(","))).collect(toList());
            Map<String, Integer> map = values.stream()
                    .map(i -> new ItemModel((i.get(0)), LocalDate.parse(i.get(1), DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(i.get(2)), new BigDecimal(i.get(3))))
                    .collect(groupingBy(ItemModel::getItem, summingInt(ItemModel::getUnitSold)));

            Optional<Map.Entry<String, Integer>> maxEntry = map.entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue));
            Object item = maxEntry.get().getKey();
            System.out.println("The most item sold in Manila: \n" + item);
    }
}
