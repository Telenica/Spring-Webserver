package com.example.WebProject;

//Exception, falls der gesuchte Feind nicht gefunden wurde
public class EnemyNotFoundException extends RuntimeException{
    EnemyNotFoundException(Long id){
        super("Feind konnte nicht gefunden werden" + id);
    }
}
