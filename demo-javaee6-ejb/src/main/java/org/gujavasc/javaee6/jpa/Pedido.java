/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gujavasc.javaee6.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodrigo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByNumero", query = "SELECT p FROM Pedido p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pedido.findByData", query = "SELECT p FROM Pedido p WHERE p.data = :data"),
    @NamedQuery(name = "Pedido.findByStatus", query = "SELECT p FROM Pedido p WHERE p.status = :status"),
    @NamedQuery(name = "Pedido.findByDataCompra", query = "SELECT p FROM Pedido p WHERE p.dataCompra = :dataCompra"),
    @NamedQuery(name = "Pedido.findByIdCliente", query = "SELECT p FROM Pedido p WHERE p.idCliente = :idCliente"),
    @NamedQuery(name = "Pedido.findByIdPagamento", query = "SELECT p FROM Pedido p WHERE p.idPagamento = :idPagamento")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer numero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Size(max = 20)
    @Column(length = 20)
    private String status;
    @Column(name = "data_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente", nullable = false)
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pagamento", nullable = false)
    private int idPagamento;

    public Pedido() {
    }

    public Pedido(Integer numero) {
        this.numero = numero;
    }

    public Pedido(Integer numero, int idCliente, int idPagamento) {
        this.numero = numero;
        this.idCliente = idCliente;
        this.idPagamento = idPagamento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gujavasc.javaee6.jpa.Pedido[ numero=" + numero + " ]";
    }
    
}
