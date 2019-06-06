package com.minerav.dto.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.minerav.dto.annotation.EntityField;
import com.minerav.dto.exception.DTOMapperException;

public class DTOMapper {

	@SuppressWarnings("rawtypes")
	public Object mapDTO(Class<Object> dtoClass, Object entity) throws DTOMapperException{
		if(entity==null) {
			return null;
		}
		Object dtoObject = null;
		Class entityClass = entity.getClass();
		try {
			 dtoObject= dtoClass.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| NoSuchMethodException | InvocationTargetException e) {
			throw new DTOMapperException(e);
		} 
		Field[] fields= dtoClass.getFields();
		for(Field field : fields) {
			String fieldName = field.getName();
			if(field.isAnnotationPresent(EntityField.class)) {
				fieldName =field.getAnnotation(EntityField.class).name();
			}
			try {
					entityClass.getField(fieldName).setAccessible(true);
					field.set(dtoObject, entityClass.getField(fieldName).get(entity));
				}
				catch(NoSuchFieldException | IllegalAccessException e) {
					throw new DTOMapperException(e);
				}
		}
		return dtoObject;
	}
}
