
public class Posgrado extends Estudiante {
    public String modalidad;
    public Posgrado(String nom, int ed, String pro, String etnia, String mod){
        super(nom, ed, pro, etnia );
        modalidad = mod;
    }    
}
