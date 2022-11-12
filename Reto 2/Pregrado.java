

public class Pregrado extends Estudiante {
    public String cantidad_creditos;
    public Pregrado(String nom, int ed, String pro, String etnia, String cantcre){
        super(nom, ed, pro, etnia);
        cantidad_creditos = cantcre;
    }
}
