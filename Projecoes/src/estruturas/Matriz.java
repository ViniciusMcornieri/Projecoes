/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

public class Matriz {

    public int linhas = 0;
    public int colunas = 0;
    public float[][] m;

  public  Matriz(int linhasEntrada, int colunasEntradas, float val) {
        linhas = linhasEntrada;
        colunas = colunasEntradas;
        m = new float[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                m[i][j] = val;
            } 
        }
    }

    public Matriz(float[][] in_data) {
        linhas = in_data.length;
        colunas = in_data[0].length;
        for (int i = 0; i < linhas; i++) {
            if (in_data[i].length != colunas) {
                throw new IllegalArgumentException("Todas as linhas tem que ter o mesmo tamanho");
            }
        }
        m = in_data;
    }

    public int getRows() {
        return (linhas);
    }

    public int getColumns() {
        return (colunas);
    }

    public float getElement(int i, int j) {
        return (m[i][j]);
    }

    public void setElement(int i, int j, float value) {
        m[i][j] = value;
    }

    public Matriz mult(Matriz b) {
        float sum = 0;
        int i, j, k;
        if (linhas != b.colunas) {
            throw new IllegalArgumentException("Tamanho da matrizes, não é possivel multiplica-las");
        }
        Matriz result = new Matriz(b.linhas, colunas, 0);
        for (i = 0; i < b.linhas; i++) {
            for (j = 0; j < colunas; j++) {
                sum = 0;
                for (k = 0; k < linhas; k++) {
                    sum = sum + b.getElement(i, k) * m[k][j];
                }
                result.m[i][j] = sum;
            }
        }
        return result;
    }

    public void aplicaTransf(Matriz b) {
        float sum = 0;
        int i, j, k;
        if (linhas != b.colunas) {
            throw new IllegalArgumentException("Matriz não pode ser transformada.");
        }
        float[][] result = new float[b.linhas][colunas];
        for (i = 0; i < b.linhas; i++) {
            for (j = 0; j < colunas; j++) {
                sum = 0;
                for (k = 0; k < linhas; k++) {
                    sum = sum + b.getElement(i, k) * m[k][j];
                }
                result[i][j] = sum;
            }
        }
        m = result;
    }

    public String toString() {
        String result = new String("[");
        for (int i = 0; i < linhas; i++) {
            result += "(";
            for (int j = 0; j < colunas; j++) {
                result += m[i][j];
                if (j != (colunas - 1)) {
                    result += ", ";
                }
            } 
            result += ")\r";
        }
        result += "]";
        return (result);
    }
}
