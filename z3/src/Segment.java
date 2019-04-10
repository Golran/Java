public class Segment {
    private Vector3D PointA;
    private Vector3D PointB;
    private Vector3D VectorAB;
    private Vector3D VectorBA;

    public Segment(Vector3D pointA, Vector3D pointB) {
        PointA = pointA;
        PointB = pointB;
        VectorAB = PointB.sub(PointA);
        VectorBA = PointA.sub(PointB);
    }

    public double len() {
        return VectorAB.len();
    }

    public double distanceToPoint(Vector3D pointC) {
        var vectorAC = pointC.sub(PointA);
        var vectorBC = pointC.sub(PointB);
        var scalarCAAB = vectorAC.scalar(VectorAB);
        var scalarCBBA = vectorBC.scalar(VectorBA);
        if (scalarCAAB <= 0) return Math.min(vectorAC.len(),vectorBC.len()) ;
        if (scalarCBBA <= 0) return Math.min(vectorAC.len(),vectorBC.len());
        if (scalarCAAB > 0 && scalarCBBA > 0) return height(VectorAB.len(), vectorAC.len(), vectorBC.len());
        return 0.0;
    }

    private double height(double distanceAB, double distanceAС, double distanceBС) {
        var semiPerimeter = (distanceAB + distanceAС + distanceBС) / 2;

        return (2 / distanceAB) * Math.sqrt
                (semiPerimeter * (semiPerimeter - distanceAB) *
                        (semiPerimeter - distanceAС) *
                        (semiPerimeter - distanceBС));
    }
}
