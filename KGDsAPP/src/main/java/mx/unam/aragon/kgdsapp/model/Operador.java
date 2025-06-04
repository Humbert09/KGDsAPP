package mx.unam.aragon.kgdsapp.model;

import java.util.Objects;

public class Operador {
    private int id;
    private String nombre;
    private String fechaNacimiento;
    private String organizacion;
    private String bando;
    private int salud;
    private int velocidad;
    private String pfp;

    public Operador() {
    }

    public Operador(int id, String nombre, String fechaNacimiento, String organizacion, String bando, int salud, int velocidad, String pfp) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.organizacion = organizacion;
        this.bando = bando;
        this.salud = salud;
        this.velocidad = velocidad;
        this.pfp = pfp;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getBando() {
        return bando;
    }

    public void setBando(String bando) {
        this.bando = bando;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Operador operador = (Operador) o;
        return id == operador.id && salud == operador.salud && velocidad == operador.velocidad && Objects.equals(nombre, operador.nombre) && Objects.equals(fechaNacimiento, operador.fechaNacimiento) && Objects.equals(organizacion, operador.organizacion) && Objects.equals(bando, operador.bando) && Objects.equals(pfp, operador.pfp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fechaNacimiento, organizacion, bando, salud, velocidad, pfp);
    }

    @Override
    public String toString() {
        return "Operador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", organizacion='" + organizacion + '\'' +
                ", bando='" + bando + '\'' +
                ", salud=" + salud +
                ", velocidad=" + velocidad +
                ", pfp='" + pfp + '\'' +
                '}';
    }
}
