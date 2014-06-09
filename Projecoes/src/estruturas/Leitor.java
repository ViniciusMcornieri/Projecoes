package estruturas;

import java.io.File;
import java.util.Scanner;

public class Leitor {

    public Objeto obj;
    public Scanner scan;

    public Leitor(String caminho) {
       try {
            File  fg  = new File(caminho);
            this.scan = new Scanner(fg);
            
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado!");
        }
        this.obj = new Objeto();
    }

    public Objeto carregar() {
        lerVertices();
        lerSuperficies();
        return this.obj;
    }
    
    public void lerVertices(){
        scan.next();
        int x,y,z,vqtt;
        vqtt = scan.nextInt();
        for(int i=0; i<vqtt; i++){
            scan.next();
            x = scan.nextInt();
            y = scan.nextInt();
            z = scan.nextInt();
            Ponto3D ponto = new Ponto3D(x, y, z);
            this.obj.pontos.add(ponto);
        }
    }
    public void lerSuperficies(){
        scan.next();
        int x, sqtt;
        sqtt = scan.nextInt();
        scan.next();
        String str;
        for (int i = 0; i < sqtt; i++) {
            str = scan.next();
            Superficie spf = new Superficie();
            while(!str.equals("s") && !str.equals("#")){
                x = Integer.parseInt(str);
                spf.vertices.add(this.obj.pontos.get(x-1));
                str = scan.next();
            }
            spf.calculaNormal();
            this.obj.objeto.add(spf);
        }
    }
}
