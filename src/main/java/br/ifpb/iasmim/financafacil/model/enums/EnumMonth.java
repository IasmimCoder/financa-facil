package br.ifpb.iasmim.financafacil.model.enums;

import java.time.Month;
import java.time.YearMonth;

public enum EnumMonth {
    JANEIRO(Month.JANUARY, "Janeiro"),
    FEVEREIRO(Month.FEBRUARY, "Fevereiro"),
    MARÇO(Month.MARCH, "Março"),
    ABRIL(Month.APRIL, "Abril"),
    MAIO(Month.MAY, "Maio"),
    JUNHO(Month.JUNE, "Junho"),
    JULHO(Month.JULY, "Julho"),
    AGOSTO(Month.AUGUST, "Agosto"),
    SETEMBRO(Month.SEPTEMBER, "Setembro"),
    OUTUBRO(Month.OCTOBER, "Outubro"),
    NOVEMBRO(Month.NOVEMBER, "Novembro"),
    DEZEMBRO(Month.DECEMBER, "Dezembro");

    private final Month month;
    private final String nome;

    EnumMonth(Month month, String nome) {
        this.month = month;
        this.nome = nome;
    }

    public Month getMonth() {
        return month;
    }

    public String getNome() {
        return nome;
    }

    public static EnumMonth getByMonth(Month month) {
        for (EnumMonth enumMonth : EnumMonth.values()) {
            if (enumMonth.month.equals(month)) {
                return enumMonth;
            }
        }
        return null;
    }

    public static EnumMonth getByNome(String nome) {
        for (EnumMonth enumMonth : EnumMonth.values()) {
            if (enumMonth.nome.equalsIgnoreCase(nome)) {
                return enumMonth;
            }
        }
        return null;
    }

    public static EnumMonth getCurrentMonth() {
        YearMonth yearMonth = YearMonth.now();
        Month currentMonth = yearMonth.getMonth();
        return getByMonth(currentMonth);
    }

    public static EnumMonth getMonthOrDefault(String monthString) {
        if (monthString == null || monthString.isEmpty()) {
            return getCurrentMonth();
        }
        return getByNome(monthString);
    }
}
