package com.JuanGreenGarden.Gardening.domain.service;

import org.springframework.http.ResponseEntity;

public interface AdminInterface<T>{

    ResponseEntity<T> save(T t);
    
}

