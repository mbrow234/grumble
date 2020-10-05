package com.grumble.model.builder;

import com.grumble.model.PetAge;

public class PetAgeBuilder {

    private Integer years;
    private Integer months;
    private Integer weeks;
    private Integer days;

    public PetAgeBuilder withYears(Integer years) {
        this.years = years;
        return this;
    }

    public PetAgeBuilder withMonths(Integer months) {
        this.months = months;
        return this;
    }

    public PetAgeBuilder withWeeks(Integer weeks) {
        this.weeks = weeks;
        return this;
    }

    public PetAgeBuilder withDays(Integer days) {
        this.days = days;
        return this;
    }

    public PetAge build() {
        PetAge petAge = new PetAge();
        petAge.setYears(years);
        petAge.setMonths(months);
        petAge.setWeeks(weeks);
        petAge.setDays(days);
        return petAge;
    }

}
