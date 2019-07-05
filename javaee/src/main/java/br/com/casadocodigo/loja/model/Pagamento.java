package br.com.casadocodigo.loja.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;


    private BigDecimal value;

    public Pagamento(BigDecimal value) {
        this.value = value;
    }
    
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}