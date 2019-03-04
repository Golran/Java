import junit.framework.TestCase;

public class Vector3DTest extends TestCase {

    private Vector3D Vector;
    public void setUp() {
        Vector = new Vector3D(1,2,3);
    }

    public void testGetX() {
        assertEquals(1.0,Vector.GetX(),1E-10);
    }

    public void testGetY() {
        assertEquals(2.0,Vector.GetY(),1E-10);
    }

    public void testGetZ() {
        assertEquals(3.0,Vector.GetZ(),1E-10);
    }

    public void testScalar() {
        assertEquals(0.0,Vector.scalar(new Vector3D(1,1,-1)),1E-10);
    }

    public void testLen() {
        assertEquals(Math.sqrt(1.0 + 4.0 + 9.0),Vector.len(),1E-10);
    }

    public void testMultiply() {
        assertEquals(new Vector3D(2.0,4.0,6.0), Vector.multiply(2.0));
    }

    public void testAdd() {
        assertEquals(new Vector3D(2.0,3.0,2.0), Vector.add(new Vector3D(1.0,1.0,-1.0)));
    }

    public void testSub() {
        assertEquals(new Vector3D(0.0,1.0,4.0), Vector.sub(new Vector3D(1.0,1.0,-1.0)));
    }

    public void testVecX() {
        assertEquals(new Vector3D(-1.0,2.0,-1.0), Vector.vecX(new Vector3D(1.0,1.0,1.0)));
    }
}