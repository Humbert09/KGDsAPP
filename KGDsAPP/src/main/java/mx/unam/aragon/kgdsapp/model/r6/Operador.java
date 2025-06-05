package mx.unam.aragon.kgdsapp.model.r6;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "operador")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "equipo", nullable = false, length = 50)
    private String equipo;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Column(name = "edad", nullable = false)
    private int edad;
    @Column(name = "imagen", nullable = true, insertable = true, columnDefinition = "VARCHAR(350) DEFAULT 'https://png.pngtree.com/png-vector/20230407/ourmid/pngtree-placeholder-line-icon-vector-png-image_6691835.png'")
    private String imagen;

    public Operador() {
    }

    public Operador(long id, String nombre, String equipo, String descripcion, int edad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.descripcion = descripcion;
        this.edad = edad;
        this.imagen = imagen;
    }

    public long getId() {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Operador operador = (Operador) o;
        return edad == operador.edad && Objects.equals(id, operador.id) && Objects.equals(nombre, operador.nombre) && Objects.equals(equipo, operador.equipo) && Objects.equals(descripcion, operador.descripcion) && Objects.equals(imagen, operador.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, equipo, descripcion, edad, imagen);
    }

    @Override
    public String toString() {
        return "Operador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", organizacion='" + equipo + '\'' +
                ", bando='" + descripcion + '\'' +
                ", velocidad=" + edad +
                ", url_foto='" + imagen + '\'' +
                '}';
    }
}
