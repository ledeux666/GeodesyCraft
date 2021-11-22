package ledeux.geocraft;

import java.util.Arrays;

public class GeoTasksTestDrive {

    public static void main(String[] args) {

        GeoTasks aGeoTasks = new GeoTasks();
        double[] baseXYZ = {-100.562, 63.123, -100.197};
        double[] initXYZ = {130.748, 87.234, -180.651};
        double[] finalXYZ = {160.912, 112.345, 140.642};
        aGeoTasks.setBaseXYZ(baseXYZ);
        aGeoTasks.setInitXYZ(initXYZ);
        aGeoTasks.setFinalXYZ(finalXYZ);
        System.out.println(Arrays.toString(aGeoTasks.getBaseXYZ()));
        System.out.println(Arrays.toString(aGeoTasks.getInitXYZ()));
        System.out.println(Arrays.toString(aGeoTasks.getFinalXYZ()));

        System.out.println("Обратная задача");
        aGeoTasks.inverseTask();
        System.out.println(aGeoTasks.getInitRhumb());
        System.out.println(aGeoTasks.getInitAzimuth());
        System.out.println(aGeoTasks.getElevation());
        System.out.println(aGeoTasks.getInitDistance());
        System.out.println(aGeoTasks.getInitHorizontalDistance());

        System.out.println("Прямая задача");
        aGeoTasks.directTask();
        System.out.println(aGeoTasks.getFinalRhumb());
        System.out.println(aGeoTasks.getFinalAzimuth());
        System.out.println(aGeoTasks.getFinalDistance());
        System.out.println(aGeoTasks.getFinalHorizontalDistance());
        System.out.println(aGeoTasks.getHorizontalAngle());
        System.out.println(aGeoTasks.getVerticalAngle());


    }
}
