import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

public class MonthWithMostUnitSold {
    public static void main(String[] args) throws IOException {
        Path manilaPath = Paths.get("sales/manila.csv");
        Path cebuPath = Paths.get("sales/cebu.csv");
        Path davaoPath = Paths.get("sales/davao.csv");

        Stream<String> stream = Stream.concat(Stream.concat(Files.lines(manilaPath), Files.lines(cebuPath)), Files.lines(davaoPath));
            List<List<String>> values = stream.map(line -> Arrays.asList(line.split(","))).collect(toList());
            Map<String, Integer> map = values.stream()
                    .map(i -> new ItemModel((i.get(0)), LocalDate.parse(i.get(1), DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(i.get(2)), new BigDecimal(i.get(3))))
                    .collect(Collectors.groupingBy((ItemModel itemModel) -> itemModel.getOrderDate().toString().split("-")[1], summingInt(ItemModel::getUnitSold)));

            Optional<Map.Entry<String, Integer>> maxEntry = map.entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue));
            Object item = maxEntry.get().getKey();

            System.out.println("Month with the most number (units sold) of sales from all branches: \n " + Month.of(Integer.parseInt((String) item)));

        }
    }



