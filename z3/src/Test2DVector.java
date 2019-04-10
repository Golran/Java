import java.util.Scanner;

public class Test2DVector {
    public static void main(String[] args)
    {
        var sc = new Scanner(System.in);
        System.out.println("Введите координаты вектора: ");
/*        var vector = new Vector2D(sc.nextDouble(),sc.nextDouble());
        var oVector = vector.getOrthogonalVector();

        System.out.println(vector.scalar(oVector));*/
        System.out.println("Введите координаты точки на прямой: ");
        var pointOnLine = new Vector2D(sc.nextDouble(),sc.nextDouble());
        System.out.println("Введите координаты вектора нормали: ");
        var NormalVector = new Vector2D(sc.nextDouble(),sc.nextDouble());
        System.out.println("Введите координаты точки s: ");
        var s = new Vector2D(sc.nextDouble(),sc.nextDouble());
        var result = Vector2D.symmetricPoint(pointOnLine,NormalVector,s);
        System.out.println(result.getX() +" "+ result.getY());


    }
}
