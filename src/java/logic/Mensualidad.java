/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author muril
 */
public class Mensualidad {
    int id_mensualidad;
    int mes;
    double costo;
    char estado;

    public Mensualidad( int mes, double costo) {
        this.id_mensualidad = 0;
        this.mes = mes;
        this.costo = costo;
        this.estado = 'n'; // inicializa la mensualidad como pendiente de pago
    }

    public Mensualidad() {
        this.id_mensualidad = 0;
        this.mes = 0;
        this.costo = 0;
        this.estado = 'n';
    }

    public void setMes( int mes) {
        this.mes = mes;
    }
    
    public int getId_mensualidad() {
        return id_mensualidad;
    }

    public int getMes() {
        return mes;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
