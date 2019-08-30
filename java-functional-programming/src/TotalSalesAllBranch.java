
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TotalSalesAllBranch {
    public static void main(String[] args) throws IOException {
        Path manilaPath = Paths.get("sales/manila.csv");
        Path cebuPath = Paths.get("sales/cebu.csv");
        Path davaoPath = Paths.get("sales/davao.csv");

        Stream<String> stream = Stream.concat(Stream.concat(Files.lines(manilaPath), Files.lines(cebuPath)), Files.lines(davaoPath));
        List<List<String>> values = stream.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
        Double sales = values.stream()
                .map(i -> Double.parseDouble(i.get(2)) * Double.parseDouble(i.get(3)))
                .reduce(0.0, Double::sum);

        System.out.println("The total sales of all branch: " + sales);

    }
}