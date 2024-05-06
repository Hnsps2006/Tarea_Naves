/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea_naves;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author eliza
 */
enum TipoNave {
    CAZA("Caza"),
    CARGA("Carga"),
    EXPLORADOR("Explorador");

    private final String tipo;

    TipoNave(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

enum TipoUniverso {
    ALIEN("Alien"),
    STARTRECK("StarTreck"),
    STARWARS("StarWars");

    private final String tipo;

    TipoUniverso(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

public class NaveEspacial {

    private int id;
    private String nombre;
    private TipoNave tipoNave;
    private TipoUniverso tipoUniverso;

    public NaveEspacial(int id, String nombre, TipoNave tipoNave, TipoUniverso tipoUniverso) {
        this.id = id;
        this.nombre = nombre;
        this.tipoNave = tipoNave;
        this.tipoUniverso = tipoUniverso;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoNave getTipoNave() {
        return tipoNave;
    }

    public TipoUniverso getTipoUniverso() {
        return tipoUniverso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoNave(TipoNave tipoNave) {
        this.tipoNave = tipoNave;
    }

    public void setTipoUniverso(TipoUniverso tipoUniverso) {
        this.tipoUniverso = tipoUniverso;
    }

    @Override
    public String toString() {
        return "NaveEspacial{"
                + "El id de la nave es: = " + id
                + ", El nombre de la nave es: = " + nombre + '\''
                + ", El tipo de nave es: = " + tipoNave.getTipo()
                + ", El tipo de Universo es: = " + tipoUniverso.getTipo()
                + '}';
    }
}
