package BaiduGPS;

/**
 * Create by NING on 2018/6/29.<br>
 */
public class GPS {
    private static double EARTH_RADIUS = 6378.137;//地球半径
    private static double rad(double d){
        return d*Math.PI/180;
    }

    public static double GetDistance(double lat1, double lng1, double lat2, double lng2){
        double a = rad(lat1) - rad(lat2);
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(rad(lat1))*Math.cos(rad(lat2))*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;

    }



}
