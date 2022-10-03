package org.itmo.highload.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException{
//    public EntityNotFoudException(String msg){
//        super(msg);
//    }

    public EntityNotFoundException(Class<?> clazz, UUID id) {
        super(String.format("No such entity: %s %s", clazz.getSimpleName(), id.toString()));
    }
}
