import java.util.Scanner;

public class Test2DVector {
    public static void main(String[] args)
    {
        var sc = new Scanner(System.in);
        System.out.println("Введите координаты вектора: ");
        var vector = new Vector2D(sc.nextDouble(),sc.nextDouble());
        var oVector = vector.getOrthogonalVector();
        System.out.println(vector.scalar(oVector));
    }
}
