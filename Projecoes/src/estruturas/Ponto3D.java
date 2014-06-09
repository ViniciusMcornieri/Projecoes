package estruturas;

public class Ponto3D extends Matriz {

    public Ponto3D(float x, float y, float z) {
        super(4, 1, 1);
        m[0][0] = x;
        m[1][0] = y;
        m[2][0] = z;
    }

    public String toString() {
        return ("(" + m[0][0] + "," + m[1][0] + "," + m[2][0]+ ")");
    }

    public float x() {
        return (m[0][0]);
    }

    public float y() {
        return (m[1][0]);
    }

    public float z() {
        return (m[2][0]);
    }

    public void setx(float x) {
        m[0][0] = x;
    }

    public void sety(float y) {
        m[1][0] = y;
    }

    public void setz(float z) {
        m[2][0] = z;
    }
    
    public void coordHomog(){
        m[0][0] = m[0][0] / m[3][0];
        m[1][0] = m[1][0] / m[3][0];
        m[2][0] = m[2][0] / m[3][0];
        m[3][0] = m[3][0] / m[3][0];
    }

}
