package com.bms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.bms.dto.BusRouteDto;
import com.bms.entity.BusRoute;
/**
 * 
 * @Reference https://www.baeldung.com/spring-data-partial-update
 *
 */

@Mapper(componentModel = "spring", uses = {})
public interface BusRouteMapper {
	
	BusRouteMapper INSTANCE = Mappers.getMapper(BusRouteMapper.class);
	
	//@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "id", ignore = true)
	public void updateBusRouteFromDto(BusRouteDto dto, @MappingTarget BusRoute busRoute);
	
}
