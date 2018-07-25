package com.capgemini.mappers;

public interface MapperInterface<T, K> {

	K mapToDTOfromDAO(T object);

	T mapToDAOfromDTO(K object);
}
