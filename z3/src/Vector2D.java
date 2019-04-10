public class Vector2D extends Vector {

    public Vector2D(Vector vector) {
        super(vector, 2);
    }

    public Vector2D(double x, double y) {
        super(2, new double[]{x, y});
    }

    public double getX(){
        return this.getComponent(0);
    }

    public double getY(){
        return this.getComponent(1);
    }

    public Vector2D getOrthogonalVector() {
        var x = getX();
        var y = getY();
        if (y != 0)
            return new Vector2D(1, -x / y);
        if (x != 0) return new Vector2D(-y / x, 1);
        return new Vector2D(1, 2);
    }

    public Vector2D rotateVector(double cos, double sin)
    {
        var x = getX() * cos - getY() * sin;
        var y =  getX() * sin + getY() * cos;
        return new Vector2D(x,y);
    }

    public static Vector2D symmetricPoint(Vector2D pointOnLine, Vector2D normal, Vector2D point)
    {

        var nVector = normalizeVector(normal);
        var guideVector = nVector.rotateVector(0,-1);
        double cos_line = guideVector.getX(); //косинус угла наклона прямой
        double sin_line = guideVector.getY(); //синус угла наклона прямой

        var rotPoint = point.rotateVector(cos_line, -sin_line);
        var rotPointOnLine = pointOnLine.rotateVector(cos_line, -sin_line);
        var symPoint = new Vector2D(rotPoint.getX(),rotPointOnLine.getY()
                - (rotPoint.getY() - rotPointOnLine.getY()));
        symPoint = symPoint.rotateVector(cos_line, sin_line); //повернули обратно
        return symPoint;

    }
    private static Vector2D normalizeVector(Vector2D vector)
    {
        var len = vector.len();
        return new Vector2D(vector.getX()/len, vector.getY()/len);
    }
}
