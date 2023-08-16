import java.util.*;

public class Resource implements Comparable<Resource> {
    
    private LinkedList<Parada> paradas = new LinkedList<Parada>();	//lista de requisicoes atendidas pelo recurso
	private int lastFinished;	//tempo em que a ultima requesicao alocada na sala termina
	private int id;				//identificador do recurso

		public Resource(Parada Parada, int id){
			addRequest(Parada);		//adiciona uma nova requisicao no recurso
			this.id = id;
		}

		public int getLastFinished(){
			return lastFinished;
		}

		public int getId(){
			return id;
		}

		public LinkedList<Parada> getRequests(){	//return list of lectures in the room
			return paradas;
		}

		public Parada getLastRequest(){
			return paradas.getLast();
		}

        //Adiciona uma nova requisicao ao recurso e adiciona o tempo de finalizacao da ultima requisao alocada no recurso
		public void addRequest(Parada request){
			paradas.add(request);
			lastFinished = (request.getKm());
		}

		@Override
		//Compara os recursos por tempo de finalizacao da ultima requisicao alocada.
		public int compareTo(Resource otherResource) {
			return this.getLastFinished() - otherResource.getLastFinished();
		}
}