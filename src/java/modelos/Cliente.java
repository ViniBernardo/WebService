package modelos;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gilson
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente {  
  private int id;
   
  
    private String nome,luzsala,tv,luzquato; 
  private String ventilador;
    
    
    public Cliente(){
        
    }

    public Cliente(int id, String nome,String luzsala,String ventilador,String tv,String luzquato) {
        this.id = id;
        this.nome = nome;
        this.ventilador = ventilador;
        this.luzsala = luzsala;
        this.tv = tv;
        this.luzquato = luzquato;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getLuzquato() {
        return luzquato;
    }

    public void setLuzquato(String luzquato) {
        this.luzquato = luzquato;
    }

    public String getLuzsala() {
        return luzsala;
    }

    public void setLuzsala(String luzsala) {
        this.luzsala = luzsala;
    }

    public String getVentilador() {
        return ventilador;
    }

    public void setVentilador(String ventilador) {
        this.ventilador = ventilador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
