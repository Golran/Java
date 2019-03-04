public class Vector3D {
    private double X;
    private double Y;
    private double Z;
    private static final double Eps = 1E-10;

    public Vector3D(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector3D)) return false;
        var vector = ((Vector3D) obj);
        return comparisonWithAccuracy(X,vector.GetX())
                && comparisonWithAccuracy(Y,vector.GetY())
                && comparisonWithAccuracy(Z,vector.GetZ());
    }

    private boolean comparisonWithAccuracy(double x, double y) {
        return x > y - Eps && x < y + Eps;
    }

    public double GetX() {
        return X;
    }

    public double GetY() {
        return Y;
    }

    public double GetZ() {
        return Z;
    }

    public double scalar(Vector3D v) {
        return v.X * X + v.Y * Y + v.Z * Z;
    }// скалярное произведение векторов

    public double len() {
        return Math.sqrt(scalar(this));
    }// длина вектора

    public Vector3D multiply(double factor) {
        var x = X * factor;
        var y = Y * factor;
        var z = Z * factor;
        return new Vector3D(x, y, z);
    }

    public Vector3D add(Vector3D v) {
        var x = X + v.X;
        var y = Y + v.Y;
        var z = Z + v.Z;
        return new Vector3D(x, y, z);
    } // сложение векторов

    public Vector3D sub(Vector3D v) {
        var x = X - v.X;
        var y = Y - v.Y;
        var z = Z - v.Z;
        return new Vector3D(x, y, z);
    }// вычитание векторов

    public Vector3D vecX(Vector3D v) {
        var x = Y * v.Z - Z * v.Y;
        var y = Z * v.X - X * v.Z;
        var z = X * v.Y - Y * v.X;
        return new Vector3D(x, y, z);
    }// векторное произведение векторов
}
