package ru.sbercourses.operation;

public interface Operation<V, O> {
    V calculate(V v, O o, V u);
}
