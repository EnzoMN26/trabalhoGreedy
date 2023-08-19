import java.util.*;

public class Recurso {
    
    private LinkedList<Parada> paradas = new LinkedList<Parada>();	//lista de requisicoes atendidas pelo recurso

		public LinkedList<Parada> getRequests(){	//return list of lectures in the room
			return paradas;
		}

        //Adiciona uma nova requisicao ao recurso e adiciona o tempo de finalizacao da ultima requisao alocada no recurso
		public void addRequest(Parada request){
			paradas.add(request);
		}

		@Override
		public String toString(){
			String a = "";
			for (Parada parada : paradas) {
				a += parada.toString() + "\n";
			}
			return a;
		}
}