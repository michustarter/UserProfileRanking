package com.capgemini.mappers;

public interface MapperInterface<T, K> {

	K mapToDTOfromEntity(T object); 

	T mapToEntityFromDTO(K object);
}
