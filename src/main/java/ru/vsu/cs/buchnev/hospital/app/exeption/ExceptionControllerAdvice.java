package ru.vsu.cs.buchnev.hospital.app.exeption;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = "Ошибка добавления/редактирования/удаления из БД!";
        // Вместо вывода сообщения в консоль, вы можете логировать его, если это необходимо
        ex.printStackTrace();
        return new ResponseEntity<>(new Response(message), HttpStatus.CONFLICT);
    }
}
