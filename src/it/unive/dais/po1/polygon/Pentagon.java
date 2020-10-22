package it.unive.dais.po1.polygon;

public class Pentagon extends Polygon {

    public Pentagon(int edge1, int edge2, int edge3, int edge4, int edge5) {
        edge = new int[5];
        edge[0]=edge1;
        edge[1]=edge2;
        edge[2]=edge3;
        edge[3]=edge4;
        edge[4]=edge5;
    }

}
