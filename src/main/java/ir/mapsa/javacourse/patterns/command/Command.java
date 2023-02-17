package ir.mapsa.javacourse.patterns.command;

public interface Command<T,E> {

    T execute(E e);
}
