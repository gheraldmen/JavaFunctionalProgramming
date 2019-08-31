import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;

public class TotalSalesEachBranch {
    public static void main(String[] args) throws IOException {
                getTotalSalesEachBranch();
    }

    public static void getTotalSalesEachBranch() throws IOException {
        Path manilaPath = Paths.get("sales/manila.csv");
        Path cebuPath = Paths.get("sales/cebu.csv");
        Path davaoPath = Paths.get("sales/davao.csv");

        Stream<List> stream = Stream.of(
                List.of("Manila Total Sales", getEachTotalSales(manilaPath)),
                List.of("Cebu Total Sales", getEachTotalSales(cebuPath)),
                List.of("Davao Total Sales", getEachTotalSales(davaoPath)));
        stream.forEach(System.out::println);
    }

    public static BigDecimal getEachTotalSales(Path eachPath) throws IOException {

        Stream<String> stream = Files.lines(eachPath);
        List<List<String>> values = stream.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
       BigDecimal sales= values.stream()
                .map(i -> new ItemModel((i.get(0)), LocalDate.parse(i.get(1), DateTimeFormatter.ofPattern("M/d/yyyy")), Integer.parseInt(i.get(2)), new BigDecimal(i.get(3))))
                .map(i->i.getPrice().multiply(BigDecimal.valueOf(i.getUnitSold())))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
       return sales;
    }

}
