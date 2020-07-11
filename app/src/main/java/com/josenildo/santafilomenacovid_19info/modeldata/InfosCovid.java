package com.josenildo.santafilomenacovid_19info.modeldata;

public class InfosCovid {
    String cidade;                     // Nome da cidade
    int cityIbgeCode;                  // Código do IBGE (código da cidade)
    int confirmados;                   // Total de casos já confirmados (acumulativo)
    double casosConfirmadosPor100k;    // taxa de casos confirmados por 100K habitantes
    String data;                       // Data da ultima atualização
    int taxaMortalidade;               // Taxa de mortalidade
    int mortes;                        // Número de mortes
    int populacaoEstimada2019;         // População estimada em 2019
    int orderForPlace;                 // Não sei ainda
    String placeType;                  // Tipo de lugar, nesse caso, "city"
    String estado;                     // Estado, nesse caso, "PE"

    // Metodo construtor da classe
    public InfosCovid(String cidade, int cityIbgeCode, int confirmados, double casosConfirmadosPor100k, String data, int taxaMortalidade, int mortes, int populacaoEstimada2019, int orderForPlace, String placeType, String estado) {
        this.cidade = cidade;
        this.cityIbgeCode = cityIbgeCode;
        this.confirmados = confirmados;
        this.casosConfirmadosPor100k = casosConfirmadosPor100k;
        this.data = data;
        this.taxaMortalidade = taxaMortalidade;
        this.mortes = mortes;
        this.populacaoEstimada2019 = populacaoEstimada2019;
        this.orderForPlace = orderForPlace;
        this.placeType = placeType;
        this.estado = estado;
    }

    // Getters & Setters

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCityIbgeCode() {
        return cityIbgeCode;
    }

    public void setCityIbgeCode(int cityIbgeCode) {
        this.cityIbgeCode = cityIbgeCode;
    }

    public int getConfirmados() {
        return confirmados;
    }

    public void setConfirmados(int confirmados) {
        this.confirmados = confirmados;
    }

    public double getCasosConfirmadosPor100k() {
        return casosConfirmadosPor100k;
    }

    public void setCasosConfirmadosPor100k(double casosConfirmadosPor100k) {
        this.casosConfirmadosPor100k = casosConfirmadosPor100k;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTaxaMortalidade() {
        return taxaMortalidade;
    }

    public void setTaxaMortalidade(int taxaMortalidade) {
        this.taxaMortalidade = taxaMortalidade;
    }

    public int getMortes() {
        return mortes;
    }

    public void setMortes(int mortes) {
        this.mortes = mortes;
    }

    public int getPopulacaoEstimada2019() {
        return populacaoEstimada2019;
    }

    public void setPopulacaoEstimada2019(int populacaoEstimada2019) {
        this.populacaoEstimada2019 = populacaoEstimada2019;
    }

    public int getOrderForPlace() {
        return orderForPlace;
    }

    public void setOrderForPlace(int orderForPlace) {
        this.orderForPlace = orderForPlace;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
