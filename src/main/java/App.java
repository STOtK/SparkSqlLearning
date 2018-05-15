import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.LinkedList;
import java.util.List;


/**
 *
 */
public class App {
    public static String sql = "select * from mytest.kmeans limit 10";

    public static void main(String[] args) {
        try {
            SparkConf sparkConf = new SparkConf();
            SparkSession spark = SparkSession
                    .builder()
                    .master("local[*]")
                    .appName("createSparkSession")
                    .config(sparkConf)
                    .enableHiveSupport()
                    .getOrCreate();
            Dataset<Row> dataset = spark.sql("select * from mytest.numbers");
            List<Row> rowList = dataset.collectAsList();
            for (Row item : rowList) {
                System.out.println(item);
            }
            System.out.println(11);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
