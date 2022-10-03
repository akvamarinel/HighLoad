package org.itmo.highload.exception;

import java.util.UUID;

public class EntityNotFoudException extends RuntimeException{
//    public EntityNotFoudException(String msg){
//        super(msg);
//    }

    public EntityNotFoudException(Class<?> clazz, UUID id) {
        super(String.format("No such entity: %s %s", clazz.getSimpleName(), id.toString()));
    }
}
