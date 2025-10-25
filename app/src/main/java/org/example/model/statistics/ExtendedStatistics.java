package org.example.model.statistics;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@ToString
@Getter
@Setter
public class ExtendedStatistics implements Statistics<LocalDate> {

    private LocalDate dateStart;

    private LocalDate dateEnd;

    public ExtendedStatistics() {}

    public ExtendedStatistics(LocalDate dateStart, LocalDate dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

}
