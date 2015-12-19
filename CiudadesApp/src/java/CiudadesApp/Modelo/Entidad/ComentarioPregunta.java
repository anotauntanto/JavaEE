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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inftel08
 */
@Entity
@Table(name = "COMENTARIO_PREGUNTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioPregunta.findAll", query = "SELECT c FROM ComentarioPregunta c"),
    @NamedQuery(name = "ComentarioPregunta.findByIdComentario", query = "SELECT c FROM ComentarioPregunta c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "ComentarioPregunta.findByTexto", query = "SELECT c FROM ComentarioPregunta c WHERE c.texto = :texto")})
public class ComentarioPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "genSeqComPregunta", sequenceName = "SEQ_IDCOMENTARIOPREGUNTA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genSeqComPregunta")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMENTARIO")
    private Integer idComentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "TEXTO")
    private String texto;
    @JoinColumn(name = "ID_PREGUNTA", referencedColumnName = "ID_PREGUNTA")
    @ManyToOne(optional = false)
    private Pregunta idPregunta;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public ComentarioPregunta() {
    }

    public ComentarioPregunta(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public ComentarioPregunta(Integer idComentario, String texto) {
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

    public Pregunta getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Pregunta idPregunta) {
        this.idPregunta = idPregunta;
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
        if (!(object instanceof ComentarioPregunta)) {
            return false;
        }
        ComentarioPregunta other = (ComentarioPregunta) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CiudadesApp.Modelo.Entidad.ComentarioPregunta[ idComentario=" + idComentario + " ]";
    }

}
