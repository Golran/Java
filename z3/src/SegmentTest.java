import java.util.Scanner;

public class SegmentTest {
    public static void main(String[] args)
    {
        var sc = new Scanner(System.in);
        System.out.println("Введите координаты начала отрезка АB: ");
        var pointA = new Vector3D(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        System.out.println("Введите координаты конца отрезка АB: ");
        var pointB = new Vector3D(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        System.out.println("Введите координаты точки С: ");
        var pointC = new Vector3D(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        var segment = new Segment(pointA,pointB);

        System.out.println("Длинна отрезка равна " + segment.len());
        System.out.println("Расстояние от точки С до отрезка AB равно " + segment.distanceToPoint(pointC));
    }
}
