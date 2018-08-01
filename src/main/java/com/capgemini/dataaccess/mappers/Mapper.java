package com.capgemini.dataaccess.mappers;

public interface Mapper<ENTITY, DTO> {

	/**
	 * @param entity
	 *            must not be null
	 * @return DTO object
	 */
	DTO mapToDTO(ENTITY entity);

	/**
	 * @param dto
	 *            must not be null
	 * @return ENTITY object
	 */
	ENTITY mapToEntity(DTO dto);
}
