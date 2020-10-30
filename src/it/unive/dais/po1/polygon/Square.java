package it.unive.dais.po1.polygon;

import it.unive.dais.po1.Printable;

public class Square extends Rectangle implements Printable {
    public Square(int edge) {
        super(edge, edge);
    }

    @Override
    public void print() {
        System.out.println("This is a square with edges of "+super.edge[0]+" cm.");
    }
}

