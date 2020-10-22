package it.unive.dais.po1.polygon;

abstract public class Quadrilateral extends Polygon {

    public Quadrilateral(int edge1, int edge2, int edge3, int edge4) {
        edge = new int[4];
        edge[0]=edge1;
        edge[1]=edge2;
        edge[2]=edge3;
        edge[3]=edge4;
    }

    public Polygon addEdge(int length) {
        return new Pentagon(edge[0], edge[1],edge[2],edge[3],length);
    }

    abstract public int getArea();
}
