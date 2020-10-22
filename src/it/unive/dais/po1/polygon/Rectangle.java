package it.unive.dais.po1.polygon;

public class Rectangle extends Quadrilateral {
    public int edge1Length;
    public int edge2Length;

    public Rectangle(int edge1, int edge2) {
        super(edge1, edge1, edge2, edge2);
        this.edge1Length = edge1;
        this.edge2Length = edge2;
    }

    public int getArea() {
        return
                this.edge1Length * this.edge2Length;
    }
}
