package org.example.model.statistics;


public interface Statistics<D> {

    D getDateStart();

    D getDateEnd();

    void setDateStart(D d);

    void setDateEnd(D d);
}
