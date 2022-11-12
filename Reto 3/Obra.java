

import java.util.ArrayList;

public class Obra {
    
    /*
    public static void main(String[] args) {
        ArrayList<Integer> metodo1 = new ArrayList<>();
        ArrayList<Integer> metodo2A = new ArrayList<>();
        ArrayList<Integer> metodo2B = new ArrayList<>();
        int metodo2C = 2;
        ArrayList<Integer> metodo3A = new ArrayList<>();
        ArrayList<Integer> metodo3B = new ArrayList<>();
        ArrayList<Integer> metodo4A = new ArrayList<>();
        ArrayList<Integer> metodo4B = new ArrayList<>();
        
        //Entrada metodo 1.
        //[1,2,5,5,5,1,2,5,5,5]
        metodo1.add(1);
        metodo1.add(2);
        metodo1.add(5);
        metodo1.add(5);
        metodo1.add(5);
        metodo1.add(1);
        metodo1.add(2);
        metodo1.add(5);
        metodo1.add(5);
        metodo1.add(5);
        clases(metodo1);

        System.out.println(clases(metodo1));
        
        //Entrada metodo 2.
        //([1,3,6,8], [1,2,5,5,5,1,2,5,5,5], 5)
        metodo2A.add(1);
        metodo2A.add(3);
        metodo2A.add(6);
        metodo2A.add(8);
        metodo2B.add(1);
        metodo2B.add(2);
        metodo2B.add(5);
        metodo2B.add(5);
        metodo2B.add(5);
        metodo2B.add(1);
        metodo2B.add(2);
        metodo2B.add(5);
        metodo2B.add(5);
        metodo2B.add(5);

        System.out.println(meFaltanDeLaClase(metodo2A, metodo2B, metodo2C));
        
        //Entrada metodo 3.
        //([3,5,7,10,15,16],[4,10,5,8])
        metodo3A.add(3);
        metodo3A.add(5);
        metodo3A.add(7);
        metodo3A.add(10);
        metodo3A.add(15);
        metodo3A.add(16);
        metodo3B.add(4);
        metodo3B.add(10);
        metodo3B.add(5);
        metodo3B.add(8);

        System.out.println(noTengo(metodo3A, metodo3B));
        
        //Entrada metodo 4.
        //([3,5,7,10,15,16],[4,10,5,8])
        metodo4A.add(3);
        metodo4A.add(5);
        metodo4A.add(7);
        metodo4A.add(10);
        metodo4A.add(15);
        metodo4A.add(16);
        metodo4B.add(4);
        metodo4B.add(10);
        metodo4B.add(5);
        metodo4B.add(8);
        
        System.out.println(puedoCambiar(metodo4A, metodo4B));
    }
    */
    public static ArrayList<Integer> clases(ArrayList<Integer> Obras) {
        ArrayList<Integer> retornoListaObras = new ArrayList<Integer>();
        for (int i = 0; i < Obras.size(); i++) {
            if (!retornoListaObras.contains(Obras.get(i))) {
                retornoListaObras.add(Obras.get(i));
            }
        }
        return retornoListaObras;
    }

    public static ArrayList<Integer> meFaltanDeLaClase(ArrayList<Integer> obrasFaltantes, ArrayList<Integer> categoriaPerteneciente, Integer numeroCategoria) {
        ArrayList<Integer> retornoListasObras = new ArrayList<Integer>();
        for (int i = 0; i < obrasFaltantes.size(); i++) {
            int obra = obrasFaltantes.get(i);
            if (categoriaPerteneciente.get(obra) == numeroCategoria) {
                retornoListasObras.add(obra);
            }
        }
        return retornoListasObras;
    }

    public static ArrayList<Integer> noTengo(ArrayList<Integer> obrasMuseoA, ArrayList<Integer> obrasMuseoB) {
        ArrayList<Integer> retornoListaObras = new ArrayList<>();
        for (int i = 0; i < obrasMuseoA.size(); i++) {
            if (!obrasMuseoB.contains(obrasMuseoA.get(i))) {
                retornoListaObras.add(obrasMuseoA.get(i));
            }
        }
        return retornoListaObras;
    }

    public static Integer puedoCambiar(ArrayList<Integer> duplicadosMuseoA, ArrayList<Integer> duplicadosMuseoB) {
        ArrayList<Integer> retornoListaObras1 = new ArrayList<>();
        ArrayList<Integer> retornoListaObras2 = new ArrayList<>();

        for (int i = 0; i < duplicadosMuseoA.size(); i++) {
            if (!duplicadosMuseoB.contains(duplicadosMuseoA.get(i))) {
                retornoListaObras1.add(duplicadosMuseoA.get(i));
            }
        }
        for (int i = 0; i < duplicadosMuseoB.size(); i++) {
            if (!duplicadosMuseoA.contains(duplicadosMuseoB.get(i))) {
                retornoListaObras2.add(duplicadosMuseoB.get(i));
            }
        }
        int min1 = retornoListaObras1.size();
        int min2 = retornoListaObras2.size();
        return Math.min(min1, min2);
    }
}
