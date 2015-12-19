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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inftel08
 */
@Entity
@Table(name = "USUARIO_EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioEvento.findAll", query = "SELECT u FROM UsuarioEvento u"),
    @NamedQuery(name = "UsuarioEvento.findByIdUsuarioevento", query = "SELECT u FROM UsuarioEvento u WHERE u.idUsuarioevento = :idUsuarioevento")})
public class UsuarioEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "genSeqUsuarioEvento", sequenceName = "SEQ_IDUSUARIOEVENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genSeqUsuarioEvento")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIOEVENTO")
    private Integer idUsuarioevento;
    @JoinColumn(name = "ID_EVENTO", referencedColumnName = "ID_EVENTO")
    @ManyToOne(optional = false)
    private Evento idEvento;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public UsuarioEvento() {
    }

    public UsuarioEvento(Integer idUsuarioevento) {
        this.idUsuarioevento = idUsuarioevento;
    }

    public Integer getIdUsuarioevento() {
        return idUsuarioevento;
    }

    public void setIdUsuarioevento(Integer idUsuarioevento) {
        this.idUsuarioevento = idUsuarioevento;
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
        hash += (idUsuarioevento != null ? idUsuarioevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEvento)) {
            return false;
        }
        UsuarioEvento other = (UsuarioEvento) object;
        if ((this.idUsuarioevento == null && other.idUsuarioevento != null) || (this.idUsuarioevento != null && !this.idUsuarioevento.equals(other.idUsuarioevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CiudadesApp.Modelo.Entidad.UsuarioEvento[ idUsuarioevento=" + idUsuarioevento + " ]";
    }
    
}
