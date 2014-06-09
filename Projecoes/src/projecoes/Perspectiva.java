
package projecoes;
import estruturas.*;

public class Perspectiva extends Matriz{
    
    public Superficie plano;
    public Ponto3D pontoVisao;
    public float d;
    public float d0;
    public float d1;

    public Perspectiva(Superficie plano, Ponto3D pv) {
        super(4, 4, 1);
        this.plano = plano;
        this.pontoVisao = pv;
    }
    
    public void calculaMatriz(){
        this.d0 = (plano.normal.x() * plano.vertices.get(0).x())
                + (plano.normal.y() * plano.vertices.get(0).y())
                + (plano.normal.z() * plano.vertices.get(0).z());
        
        this.d1 = (plano.normal.x() * pontoVisao.x())
                + (plano.normal.y() * pontoVisao.y())
                + (plano.normal.z() * pontoVisao.z());
        
        this.d  = d0 - d1;
        
        m[0][0] = pontoVisao.x()*plano.normal.x() + d;
        m[0][1] = pontoVisao.x()*plano.normal.y();
        m[0][2] = pontoVisao.x()*plano.normal.z();
        m[0][3] = -1 * pontoVisao.x() * d0;
        
        m[1][0] = pontoVisao.y()*plano.normal.x();
        m[1][1] = pontoVisao.y()*plano.normal.y() + d;
        m[1][2] = pontoVisao.y()*plano.normal.z();
        m[1][3] = -1 * pontoVisao.y() * d0;
        
        m[2][0] = pontoVisao.z()*plano.normal.x();
        m[2][1] = pontoVisao.z()*plano.normal.y();
        m[2][2] = pontoVisao.z()*plano.normal.z() + d;
        m[2][3] = -1 * pontoVisao.z() * d0;
        
        m[3][0] = plano.normal.x();
        m[3][1] = plano.normal.y();
        m[3][2] = plano.normal.z();
        m[3][3] = -1 * d1;
    } 
}
