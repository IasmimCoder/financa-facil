package br.ifpb.iasmim.financafacil.model.dto;
import java.math.BigDecimal;
import java.util.Objects;


public class MonthlySummaryDTO {
    private String month;
    private int year;
    private BigDecimal  totalIncome;
    private BigDecimal  totalExpense;
    private BigDecimal balance;
    private String currency;

    public MonthlySummaryDTO() {
    }

    public MonthlySummaryDTO(String month, int year, BigDecimal totalIncome, BigDecimal totalExpense) {
        this.month = month;
        this.year = year;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = totalIncome.subtract(totalExpense);
        this.currency = "R$"; // Valor de moeda padrão
    }


    public MonthlySummaryDTO(String month, int year, BigDecimal totalIncome, BigDecimal totalExpense, String currency) {
        this.month = month;
        this.year = year;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = totalIncome.subtract(totalExpense);
        this.currency = currency;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getTotalIncome() {
        return this.totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getTotalExpense() {
        return this.totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MonthlySummaryDTO)) {
            return false;
        }
        MonthlySummaryDTO monthlySummaryDTO = (MonthlySummaryDTO) o;
        return Objects.equals(month, monthlySummaryDTO.month) && year == monthlySummaryDTO.year && Objects.equals(totalIncome, monthlySummaryDTO.totalIncome) && Objects.equals(totalExpense, monthlySummaryDTO.totalExpense) && Objects.equals(balance, monthlySummaryDTO.balance) && Objects.equals(currency, monthlySummaryDTO.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, year, totalIncome, totalExpense, balance, currency);
    }

    @Override
    public String toString() {
        return "{" +
            " month='" + getMonth() + "'" +
            ", year='" + getYear() + "'" +
            ", totalIncome='" + getTotalIncome() + "'" +
            ", totalExpense='" + getTotalExpense() + "'" +
            ", balance='" + getBalance() + "'" +
            ", currency='" + getCurrency() + "'" +
            "}";
    }

}
