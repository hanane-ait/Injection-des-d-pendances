package org.example;
import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements IDao {
    public double getData() {
        return 100;
    }
}