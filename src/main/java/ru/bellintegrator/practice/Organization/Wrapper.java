package ru.bellintegrator.practice.Organization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.Objects;

/**
 * Класс-обёртка ответов контроллеров.
 * Все возвращаемые контроллерами типы данных представлений находятся в параметре "data"
 * @param <T> тип представления
 */
@RestControllerAdvice
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class Wrapper<T> {

    @JsonView({Views.GetByIdView.class})
    private T data;

    public Wrapper() {
    }

    public Wrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrapper<?> wrapper = (Wrapper<?>) o;
        return Objects.equals(data, wrapper.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "data=" + data +
                '}';
    }
}

