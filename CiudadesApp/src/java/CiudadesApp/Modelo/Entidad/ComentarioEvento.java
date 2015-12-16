/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CiudadesApp.Modelo.Entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inftel08
 */
@Entity
@Table(name = "COMENTARIO_EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioEvento.findAll", query = "SELECT c FROM ComentarioEvento c"),
    @NamedQuery(name = "ComentarioEvento.findByIdComentario", query = "SELECT c FROM ComentarioEvento c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "ComentarioEvento.findByTexto", query = "SELECT c FROM ComentarioEvento c WHERE c.texto = :texto")})
public class ComentarioEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMENTARIO")
    private Integer idComentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "TEXTO")
    private String texto;
    @JoinColumn(name = "ID_EVENTO", referencedColumnName = "ID_EVENTO")
    @ManyToOne(optional = false)
    private Evento idEvento;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public ComentarioEvento() {
    }

    public ComentarioEvento(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public ComentarioEvento(Integer idComentario, String texto) {
        this.idComentario = idComentario;
        this.texto = texto;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioEvento)) {
            return false;
        }
        ComentarioEvento other = (ComentarioEvento) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CiudadesApp.Modelo.Entidad.ComentarioEvento[ idComentario=" + idComentario + " ]";
    }
    
}
