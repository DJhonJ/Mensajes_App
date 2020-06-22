package modelo;

public class Message {
    private int id;
    private String mensaje;
    private String autor;
    private String fecha;

    public Message() { }

    public Message(String mensaje, String autor, String fecha){
        this.mensaje = mensaje;
        this.autor = autor;
        this.fecha = fecha;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMensaje(){
        return this.mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getFecha(){
        return this.fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }
}
