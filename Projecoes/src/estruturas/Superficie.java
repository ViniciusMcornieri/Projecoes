
package estruturas;

import java.util.ArrayList;

public class Superficie  {
    public ArrayList<Ponto3D> vertices;
    public Ponto3D normal;
    public boolean visibilidade;

    public Superficie() {
        this.vertices = new ArrayList();
        this.normal   = new Ponto3D(0, 0, 0);
        this.visibilidade = true;
    }
    
    public void calculaNormal(){
        float ax, ay, az, bx, by, bz;
        ax = vertices.get(1).x() - vertices.get(0).x();
        ay = vertices.get(1).y() - vertices.get(0).y();
        az = vertices.get(1).z() - vertices.get(0).z();
        
        int vqtt = vertices.size();
        bx = vertices.get(vqtt-2).x() - vertices.get(0).x();
        by = vertices.get(vqtt-2).y() - vertices.get(0).y();
        bz = vertices.get(vqtt-2).z() - vertices.get(0).z();
        
        normal.setx(ay*bz - az*by);
        normal.sety(az*bx - ax*bz);
        normal.setz(ax*by - ay*bx);
    }
    
    public void aplicaTransf(Matriz transf){
        for (Ponto3D ponto : vertices) {
            ponto.mult(transf);
        }
    }
    
    public void coordHomog(){
       for (Ponto3D ponto : vertices) {
            ponto.coordHomog();
        }
    }
    
    public void visibilidade(Ponto3D visao){
        float vi,vj,vk;
        vi = vertices.get(0).x() - visao.x();
        vj = vertices.get(0).y() - visao.y();
        vk = vertices.get(0).z() - visao.z();
        

        
        float pEscalar = vi*normal.x()+vj*normal.y()+vk*normal.z();
        float modV     = (float) Math.sqrt(vi*vi+vj*vj+vk*vk);
        float modN     = (float) Math.sqrt(normal.x()*normal.x()+normal.y()*normal.y()+normal.z()*normal.z());
        float cosTeta  = pEscalar / modV*modN;
        if (cosTeta <= 0){
            this.visibilidade = false;
        }
        
    }
    
}
