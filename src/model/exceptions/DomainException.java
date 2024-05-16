/*
o nome Domain é pq ela é uma exceção lançada por um erro na entidade de dominio (reservation)
poderia ter outro nome.
 */
package model.exceptions;

public class DomainException extends Exception {
    public DomainException(String msg) {
        super(msg);
    }
}
