package com.example.thirdProject.mappers;

import java.util.List;

public interface CommonMapper<D, E>{
    D toDto(E entity);

    E toEntity(D dto);

    List<D> toListDto(List<E> entityList);

    List<E> toListEntity(List<D> dtoList);
}
