import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;

public class TotalSalesEachBranch {
    public static void main(String[] args) throws IOException {
        getDavaoTotalSales();
        getCebuTotalSales();
        getManilaTotalSales();
    }
    //sorry po sir mali po yung solution ko.
    public static void getDavaoTotalSales() throws IOException {
        Path davaoPath = Paths.get("sales/davao.csv");
        try (Stream<String> stream = Files.lines(davaoPath)) {
            List<List<String>> values = stream.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
            Double sales = values.stream()
                    .map(i -> Double.parseDouble(i.get(2)) * Double.parseDouble(i.get(3)))
                    .reduce(0.0, Double::sum);

            System.out.println("Davao Total Sales: " + sales);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCebuTotalSales() throws IOException {
        Path cebuPath = Paths.get("sales/cebu.csv");
        try (Stream<String> stream = Files.lines(cebuPath)) {
            List<List<String>> values = stream.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
            Double sales = values.stream()
                    .map(i -> Double.parseDouble(i.get(2)) * Double.parseDouble(i.get(3)))
                    .reduce(0.0, Double::sum);

            System.out.println("Cebu Total Sales: " + sales);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getManilaTotalSales() throws IOException {
        Path manilaPath = Paths.get("sales/manila.csv");
        try (Stream<String> stream = Files.lines(manilaPath)) {
            List<List<String>> values = stream.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
            Double sales = values.stream()
                    .map(i -> Double.parseDouble(i.get(2)) * Double.parseDouble(i.get(3)))
                    .reduce(0.0, Double::sum);

            System.out.println("Manila Total Sales: " + sales);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
