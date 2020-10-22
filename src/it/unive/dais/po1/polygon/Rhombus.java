package it.unive.dais.po1.polygon;

public class Rhombus extends Quadrilateral {

    private int edgeLength, height;
    public Rhombus(int edgeLength, int height, int edge) {
        super(edge, edge, edge, edge);
        this.edgeLength = edgeLength;
        this.height = height;
    }
    public int getArea () {
        return (this.edgeLength * this.height ) / 2;
    }
}
