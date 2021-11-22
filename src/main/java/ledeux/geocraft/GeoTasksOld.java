package ledeux.geocraft;

public class GeoTasksOld {

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

    // Направления до начальной точки и искомой
    private double initHorizontalDirectionDeg;
    private double finalHorizontalDirectionDeg;
    private double initVerticalDirectionDeg;
    private double finalVerticalDirectionDeg;
    private double initHorizontalDirection = Math.toRadians(initHorizontalDirectionDeg);
    private double finalHorizontalDirection = Math.toRadians(finalHorizontalDirectionDeg);
    private double initVerticalDirection = Math.toRadians(initVerticalDirectionDeg);
    private double finalVerticalDirection = Math.toRadians(finalVerticalDirectionDeg);

    // Горизонтальный и вертикальный углы
    private double horizontalAngle;
    private double verticalAngle;

    // Наклонные и горизонтальные расстояния до начальной и искомой точки
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

        findDistance(); // Начальное расстояние
        findRhumb(); // Румб начального направления
        rhumbToAzimuth(); // Азимут начального направления
        findHorizontalAngle(); // Горизонтальный угол между направлениями
        finalAzimuth = initAzimuth + horizontalAngle;
        double angle = Math.atan2(diffInitY, initHorizontalDistance);

        // TODO: разобраться с вертикальными углами
        double diffAngle = verticalAngle - angle;
        finalHorizontalDistance = finalDistance * Math.cos(Math.abs(diffAngle));
        double diffFinalX;
    }

    // Обратная геодезическая задача (получение азимута направления и расстояния)
    public void inverseTask() {

        findDistance();
        findRhumb();
        rhumbToAzimuth();
    }

    // Расчет расстояний
    public void findDistance() {

        initDistance = Math.sqrt(Math.pow(diffInitX, 2) + Math.pow(diffInitY, 2) + Math.pow(diffInitZ, 2));
        initHorizontalDistance = Math.sqrt(Math.pow(diffInitX, 2) + Math.pow(diffInitZ, 2));
    }

    // Расчет румба
    public void findRhumb() {

        if (diffInitX == 0) {
            initRhumb = 0;
        } else if (diffInitZ == 0) {
            initRhumb = Math.PI / 2;
        } else {
            initRhumb = Math.atan2(diffInitX, diffInitZ);
        }
    }

    // Переход от румба направления к азимуту
    public void rhumbToAzimuth() {

        if ((diffInitX <= 0) && (diffInitZ > 0)) {
            initAzimuth = initRhumb;
        }

        if ((diffInitX < 0) && (diffInitZ <= 0)) {
            initAzimuth = Math.PI - initRhumb;
        }

        if ((diffInitX >= 0) && (diffInitZ < 0)) {
            initAzimuth = Math.PI + initRhumb;
        }

        if ((diffInitX > 0) && (diffInitZ >= 0)) {
            initAzimuth = 2 * Math.PI - initRhumb;
        }
    }

    // Расчет горизонтального и вертикального угла
    public void findHorizontalAngle() {

        // Расчет предварительного значения горизонтального угла
        horizontalAngle = finalHorizontalDirection - initHorizontalDirection;
        if (horizontalAngle > Math.PI) { // Корректировка значения
            this.horizontalAngle = horizontalAngle - 2 * Math.PI;
        } else if (horizontalAngle < Math.PI) {
            this.horizontalAngle = horizontalAngle + 2 * Math.PI;
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

}
