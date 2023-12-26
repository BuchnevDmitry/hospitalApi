package ru.vsu.cs.buchnev.hospital.app.exeption;

public class DepartmentException extends RuntimeException{
    public DepartmentException() {
    }

    public DepartmentException(String message) {
        super(message);
    }
}
