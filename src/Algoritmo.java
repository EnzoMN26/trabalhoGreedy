import java.util.*;

public class Algoritmo {
    
    public static void findOptimalPartitioning(Parada[] paradas, int path, int maxDist){
            
        Arrays.sort(paradas);	//Ordena o vetor pelo tempo de finalizacao de cada requisicao
		Recurso recurso = new Recurso();
		int distAtual = 0;
		

		while(distAtual != path){ //loopa até chegar ao final da pista.

			for(int i=0; i<paradas.length; i++){ // loopa por todas as paradas da mais longe para a mais perto.

				if(paradas[i].getKm() <= maxDist + distAtual){ // se for possivel chegar na parada, adiciona ela ao recurso.
					recurso.addRequest(paradas[i]);
					distAtual = paradas[i].getKm();
					break;	//reinicia o processo.
				}

			}
		}        
		System.out.println(recurso.toString());
    }
        
     public static void main(String[] args) {
            
		int path = 26;
		int maxDist = 8;

        Parada[] paradas = {
            new Parada(2, "a"),
            new Parada(5, "b"),
            new Parada(8, "c"),
            new Parada(10, "d"),
            new Parada(10, "e"),
            new Parada(15, "f"),
            new Parada(18, "g"),
            new Parada(20, "h"),
            new Parada(21, "i"),
            new Parada(26, "j"),
        };
        
        Algoritmo.findOptimalPartitioning(paradas, path, maxDist);
    }    
}