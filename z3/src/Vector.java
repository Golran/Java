import java.util.function.BiFunction;

public class Vector {

    private int dimension;
    private double[] components;

    public Vector(int dimension, double[] components) {
        this.dimension = dimension;
        this.components = makeArrayComponents(components,dimension);
    }

    public Vector(Vector vector, int dimension) {
        this.dimension = dimension;
        this.components = makeArrayComponents(vector.components, dimension);
    }

    private double[] makeArrayComponents(double[] components, int dimension) {
        var result = new double[dimension];
        if (components.length >= dimension) {
            for (int i = 0; i < dimension; i++)
                result[i] = components[i];
            return result;
        }

        for (int i = 0; i < components.length; i++)
            result[i] = components[i];
        return result;
    }

    public int dimension() {
        return this.dimension;
    }

    public double[] getComponents(){
        return components;
    }

    public double getComponent(int i) {
        if (i < dimension && i >= 0)
            return components[i];
        throw new IllegalArgumentException("Индекс указан не верно.");
    }

    public double scalar(Vector v) {
        if (v.dimension() != this.dimension)
            throw new IllegalArgumentException("Размерности векторов не совпадают.");
        var result = 0.0;
        for (int i = 0; i < this.dimension; i++)
            result += this.components[i] * v.components[i];
        return result;
    }

    public double len() {
        return Math.sqrt(scalar(this));
    }

    public Vector multiply(double factor) {
        BiFunction<Double, Double, Double> func = (el1, el2) -> el1 * factor;
        var resultArr = changeArray(this.components, this.components, func);
        return new Vector(this.dimension, resultArr);
    }

    public Vector add(Vector v) {
        if (v.dimension() != this.dimension)
            throw new IllegalArgumentException("Размерности векторов не совпадают.");
        BiFunction<Double, Double, Double> func = (el1, el2) -> el1 + el2;
        var resultArr = changeArray(this.components, v.components, func);
        return new Vector(this.dimension, resultArr);
    }

    public Vector sub(Vector v) {
        if (v.dimension() != this.dimension)
            throw new IllegalArgumentException("Размерности векторов не совпадают.");
        BiFunction<Double, Double, Double> func = (el1, el2) -> el1 - el2;
        var resultArr = changeArray(this.components, v.components, func);
        return new Vector(this.dimension, resultArr);
    }

    private double[] changeArray(double[] array1, double[] array2,
                                 BiFunction<Double, Double, Double> func) {
        for (int i = 0; i < array1.length; i++)
            array1[i] = func.apply(array1[i], array2[i]);
        return array1;
    }
}
