package br.com.digitalhouse.livraria.model;

import javax.persistence.*;

@Entity
@Table(name = "livros")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivro;

    @Column(nullable = false, name = "nome")
    private String name;

    @Column(nullable = false, name = "valor")
    private Double value;

    @Column(nullable = false, name = "editora")
    private String vendor;

    public Library(){}

    public Library(String name, Double value, String vendor){
        this.name = name;
        this.value = value;
        this.vendor = vendor;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
