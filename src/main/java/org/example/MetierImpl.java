package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao;

    public double calcul() {
        return dao.getData() * 2;
    }
}
