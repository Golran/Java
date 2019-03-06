public class Vector2D extends Vector {
    private double x;
    private double y;

    public Vector2D(int dimension, double[] components) {
        super(2, new Vector(new Vector(dimension, components), 2).getComponents());
        x = this.getComponent(0);
        y = this.getComponent(1);
    }

    public Vector2D(Vector vector, int dimension) {
        super(vector, 2);
        x = this.getComponent(0);
        y = this.getComponent(1);
    }

    public Vector2D(double x, double y) {
        super(2, new double[]{x, y});
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public Vector2D getOrthogonalVector()
    {
        if(y!=0)
        return new Vector2D(1, -x/y);
        if(x!=0) return new Vector2D(-y/x, 1);
        return new Vector2D(1, 2);
    }

}
