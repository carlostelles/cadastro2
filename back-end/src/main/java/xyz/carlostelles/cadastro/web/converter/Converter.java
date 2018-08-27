package xyz.carlostelles.cadastro.web.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Converter<E, V> {
    public V encode(E entity) {
        return null;
    }

    public E decode(V viewBean) {
        return null;
    }

    public List<V> encodeAll(Collection<E> entities) {
        return entities.stream()
                .map(this::encode)
                .collect(Collectors.toList());
    }

    public List<E> decodeAll(Collection<V> viewBeans) {
        return viewBeans.stream()
                .map(this::decode)
                .collect(Collectors.toList());
    }
}
