package mx.unam.aragon.kgdsapp.model.diego;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "jugadors")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_jugador", nullable = false, length = 100)
    private String nombre;
    @Column(name = "equipo", nullable = false, length = 50)
    private String equipo;
    @Column(name = "descripcion", nullable = false, length = 450)
    private String descripcion;
    @Column(name = "edad", nullable = true)
    private Integer edad;
    @Column(name = "numero", nullable = true)
    private Integer numero;
    @Column(name = "url_foto", nullable = true, insertable = true, columnDefinition = "")
    private String imagen;

    public Jugador() {
    }

    public Jugador(int id, String nombre, String equipo, String descripcion, Integer edad, Integer numero, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.descripcion = descripcion;
        this.edad = edad;
        this.numero = numero;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        mx.unam.aragon.kgdsapp.model.diego.Jugador jugador = (mx.unam.aragon.kgdsapp.model.diego.Jugador) o;
        return id == jugador.id && Objects.equals(nombre, jugador.nombre) && Objects.equals(equipo, jugador.equipo) && Objects.equals(descripcion, jugador.descripcion) && Objects.equals(edad, jugador.edad) && Objects.equals(numero, jugador.numero) && Objects.equals(imagen, jugador.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, equipo, descripcion, edad, numero, imagen);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", equipo='" + equipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", edad=" + edad +
                ", numero=" + numero +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}