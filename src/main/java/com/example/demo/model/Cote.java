package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cote")
public class Cote extends BaseEntity implements Validator {
    private String code;
    private String type;
    private int quantity;
    @Column(columnDefinition="DATE", name = "import_date")
    private LocalDate importDate;
    @Column(columnDefinition="DATE", name = "export_date")
    private LocalDate exportDate;


    @ManyToOne
    @JoinColumn(name = "herd_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Herd herd;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;

    @OneToMany(mappedBy = "cote", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<HistoryExport> historyExports;

    @OneToMany(mappedBy = "cote", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<TreatmentVacxin> treatmentVacxins;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public LocalDate getExportDate() {
        return exportDate;
    }

    public void setExportDate(LocalDate exportDate) {
        this.exportDate = exportDate;
    }

    public Herd getHerd() {
        return herd;
    }

    public void setHerd(Herd herd) {
        this.herd = herd;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Collection<HistoryExport> getHistoryExports() {
        return historyExports;
    }

    public void setHistoryExports(Collection<HistoryExport> historyExports) {
        this.historyExports = historyExports;
    }

    public Collection<TreatmentVacxin> getTreatmentVacxins() {
        return treatmentVacxins;
    }

    public void setTreatmentVacxins(Collection<TreatmentVacxin> treatmentVacxins) {
        this.treatmentVacxins = treatmentVacxins;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Cote.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
