package ledeux.geocraft;

public class GeoTasks {

    // Прямоугольные координаты трех основных точек
    private double[] baseXYZ = new double[3];
    private double[] initDirXYZ = new double[3];
    private double[] finalDirXYZ = new double[3];

    // Разность прямоугольных координат базы и точки начального направления
    private double diffInitX = initDirXYZ[0]-baseXYZ[0];
    private double diffInitY = initDirXYZ[1]-baseXYZ[1];
    private double diffInitZ = initDirXYZ[2]-baseXYZ[2];

    // TODO: реализовать изменение baseHeight и aimHeight
    // Высоты тахеометра и визирных целей
    private double baseHeight = 1.70;
    private double initAimHeight = 1.70;
    private double finalAimHeight = 1.70;

    // Горизонтальный и вертикальный углы
    private double horizontalAngleDeg;
    private double horizontalAngle = Math.toRadians(horizontalAngleDeg);
    private double verticalAngleDeg;
    private double verticalAngle = Math.toRadians(verticalAngleDeg);

    // Расстояния до начальной и искомой точки
    private double initDistance;
    private double initHorizontalDistance;
    private double finalDistance;
    private double finalHorizontalDistance;

    // Румб и азимуты направлений
    private double initRhumb;
    private double initAzimuth;
    private double finalAzimuth;

    // Прямая геодезическая задача (получение координат искомого пункта)
    public void directTask() {

        initRhumb = Math.atan2(diffInitX, diffInitZ);
        finalAzimuth = initAzimuth + horizontalAngle;
        findDistance();
        double angle = Math.atan2(diffInitY, initHorizontalDistance);

        // TODO: разобраться с вертикальными углами
        double diffAngle = verticalAngle - angle;
        finalHorizontalDistance = finalDistance * Math.cos(Math.abs(diffAngle));
        double diffFinalX;
    }

    // Обратная геодезическая задача (получение азимута направления и расстояния)
    public void inverseTask() {

        // Наклонное и горизонтальное расстояние
        findDistance();
        // Находим румб и азимут начального направления
        initRhumb = Math.atan2(diffInitX, diffInitZ);
        // Находим азимут до искомой точки
        rhumbToAzimuth();
    }

    // Метод нахождения расстояний
    public void findDistance() {

        initDistance = Math.sqrt(Math.pow(diffInitX, 2) + Math.pow(diffInitY, 2) + Math.pow(diffInitZ, 2));
        initHorizontalDistance = Math.sqrt(Math.pow(diffInitX, 2) + Math.pow(diffInitZ, 2));
    }

    // Переход от румба направления к азимуту
    public void rhumbToAzimuth() {

        if ((initDirXYZ[0] - baseXYZ[0] > 0) && (initDirXYZ[2] - baseXYZ[2] > 0)) {
            initAzimuth = initRhumb;
        }

        if ((initDirXYZ[0] - baseXYZ[0] > 0) && (initDirXYZ[2] - baseXYZ[2] < 0)) {
            initAzimuth = Math.PI - initRhumb;
        }

        if ((initDirXYZ[0] - baseXYZ[0] < 0) && (initDirXYZ[2] - baseXYZ[2] < 0)) {
            initAzimuth = Math.PI + initRhumb;
        }

        if ((initDirXYZ[0] - baseXYZ[0] < 0) && (initDirXYZ[2] - baseXYZ[2] > 0)) {
            initAzimuth = 2 * Math.PI - initRhumb;
        }
    }

    // Различные сеттеры и геттеры для переменных экземпляра
    public void setBaseXYZ(double[] newBaseXYZ) {
        baseXYZ = newBaseXYZ;
    }

    public double[] getBaseXYZ() {
        return baseXYZ;
    }

    public void setInitDirXYZ(double[] newInitDirXYZ) {
        initDirXYZ = newInitDirXYZ;
    }

    public double[] getInitDirXYZ() {
        return initDirXYZ;
    }

    public void setFinalDirXYZ(double[] newFinalDirXYZ) {
        finalDirXYZ = newFinalDirXYZ;
    }

    public double[] getFinalDirXYZ() {
        return finalDirXYZ;
    }

    public void setBaseHeight(double newBaseHeight) {
        baseHeight = newBaseHeight;
    }

    public double getBaseHeight() {
        return baseHeight;
    }

    public void setInitAimHeight(double newInitAimHeight) {
        initAimHeight = newInitAimHeight;
    }

    public double getInitAimHeight() {
        return initAimHeight;
    }

    public void setFinalAimHeight(double newFinalAimHeight) {
        finalAimHeight = newFinalAimHeight;
    }

    public double getFinalAimHeight() {
        return finalAimHeight;
    }

    public void setHorizontalAngleDeg(double newHorizontalAngleDeg) {
        horizontalAngleDeg = newHorizontalAngleDeg;
    }

    public double getHorizontalAngleDeg() {
        return horizontalAngleDeg;
    }

    public void setVerticalAngleDeg(double newVerticalAngleDeg) {
        verticalAngleDeg = newVerticalAngleDeg;
    }

    public double getVerticalAngleDeg() {
        return verticalAngleDeg;
    }

    public void setInitAzimuth(double newInitAzimuth) {
        initAzimuth = newInitAzimuth;
    }

    public double getInitAzimuth() {
        return initAzimuth;
    }

    public void setFinalAzimuth(double newFinalAzimuth) {
        finalAzimuth = newFinalAzimuth;
    }

    public double getFinalAzimuth() {
        return finalAzimuth;
    }

    public void setInitRhumb(double newInitRhumb) {
        initRhumb = newInitRhumb;
    }

    public double getInitRhumb() {
            return initRhumb;
    }

    // TODO: добавить сеттеры и геттеры для всех переменных
    public void setDistance(double newDistance) {
        distance = newDistance;
    }

    public double getDistance() {
        return distance;
    }
}
