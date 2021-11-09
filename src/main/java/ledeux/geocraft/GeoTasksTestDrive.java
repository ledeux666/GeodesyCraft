package ledeux.geocraft;

import java.util.Arrays;

public class GeoTasksTestDrive {

    public static void main(String[] args) {

        GeoTasks aGeoTasks = new GeoTasks();
        double[] baseXYZ = {100.562, 63.000, 100.197};
        double[] initDirXYZ = {130.748, 63.000, 180.651};
        aGeoTasks.setBaseXYZ(baseXYZ);
        aGeoTasks.setInitDirXYZ(initDirXYZ);
        System.out.println(Arrays.toString(aGeoTasks.getBaseXYZ()));
        System.out.println(Arrays.toString(aGeoTasks.getInitDirXYZ()));
        aGeoTasks.inverseTask();
        System.out.println(Math.atan2(initDirXYZ[0]-baseXYZ[0], initDirXYZ[2]-baseXYZ[2]));
        System.out.println(aGeoTasks.getInitRhumb());
        }
}
