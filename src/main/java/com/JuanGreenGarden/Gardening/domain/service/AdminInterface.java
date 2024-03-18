package com.JuanGreenGarden.Gardening.domain.service;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminInterface<T>{
    List<T> getAll();
    ResponseEntity<T> save(T t);
    ResponseEntity<Void> delete(Long id);
}

