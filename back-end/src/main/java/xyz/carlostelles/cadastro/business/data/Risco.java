package xyz.carlostelles.cadastro.business.data;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Risco {
    A("A", 0.),
    B("B", 10.),
    C("C", 20.);

    private String taxa;
    private Double perc;

    Risco(String taxa, Double perc) {
        this.taxa = taxa;
        this.perc = perc;
    }

    public String getTaxa() {
        return taxa;
    }

    public Double getPerc() {
        return perc;
    }
}
