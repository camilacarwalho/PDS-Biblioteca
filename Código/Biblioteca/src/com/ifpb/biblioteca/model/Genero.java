package com.ifpb.biblioteca.model;
/**
 * @author Camila
 *  Enum para classificar o genero do objeto livro.
 */
public enum Genero {
    ROMANCE(1), TERROR(2), POESIA(3), FANTASIA(4), AVENTURA(5), BIOGRAFIA(6), DIDATICO(7);

    public final int ID;

     Genero(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
