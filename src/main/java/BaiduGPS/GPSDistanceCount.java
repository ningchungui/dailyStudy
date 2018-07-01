package BaiduGPS;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Create by NING on 2018/6/29.<br>
 */
public class GPSDistanceCount {
    public static void main(String[] args) throws Exception {

        FileReader fileReader = new FileReader("D:\\2610579用户行车记录.csv");
        BufferedReader reader = new BufferedReader(fileReader);

        for(;;){
            String line = reader.readLine();
            if (line == null) break;
            String[] split = line.split(",", 4);
            String gps = StringUtils.strip(split[4], "\"");

            System.out.println("字段1-->"+split[0] +"   字段2-->"+split[1]+"   字段3-->"+split[2]+"   字段4-->"+split[3]);
        }



    }

}
