import java.util.*;

public class IntervalPartitioning {
    
    public static void findOptimalPartitioning(Parada[] requests){
            
        Arrays.sort(requests);		//Ordena o vetor pelo tempo de finalizacao de cada requisicao

		ArrayList<Resource> allResources = new ArrayList<Resource>();	//lista com todos os recursos e suas respectivas requisicoes
		PriorityQueue<Resource> resourcesQueue = new PriorityQueue<Resource>();		//fila de prioridade, ordenada pelo tempo de finalizacao da ultima requisicao
		String outputMessage = "";		//apresentacao do conjunt otimo de alocadao

		int d =0;	//contador do numero de recursos necessarios
		int path = 26;

		Resource firstResource = new Resource(requests[0], ++d);		//Cria o primeiro recurso e aloca a primeira requisicao nele
		resourcesQueue.add(firstResource);	//adiciona o recurso na fila de prioridade
		allResources.add(firstResource);	//adiciona o recurso na lista com todos os recursos
		outputMessage+=requests[0]+"\tadded in resource "+firstResource.getId();

		for(int i=1; i<requests.length; i++){		//itera sobre todas as requisicoes
			Resource currentResource = resourcesQueue.peek();		//pega o recurso da fila de recursos cuja requisicao acaba primeiro
			Parada currentRequest = requests[i];	//acessa a requisicao atual do looping

			if(currentRequest.getKm() >= currentResource.getLastFinished()){		//verifica se a requisicao eh compativel com as demais requisicoes do recurso atual
                currentResource.addRequest(currentRequest);		//adiciona a requisicao no recurso e atualiza o tempo de execucao da ultima requisicao do recurso.
				resourcesQueue.remove(); //remove o topo da fila que é o recurso atual.
				resourcesQueue.add(currentResource);	//adiciona o recurso atual novamente para forcar a fila a reordenar pela prioridade.
				outputMessage+="\n"+currentRequest+"\tadded in room "+currentResource.getId();
			}
			else{
				Resource newResource = new Resource(currentRequest, ++d);	//cria um novo recurso
				resourcesQueue.add(newResource);	//adiciona na fila
				allResources.add(newResource);		//adicina na lista de todos os recuroso
				outputMessage+="\n" + currentRequest + "\tadded in room " + newResource.getId();
			}
		}
		
		outputMessage+="\n\nContents of Resources";
		for(Resource res: allResources){
			outputMessage+= "\nResource " + res.getId() + ": " + res.getRequests();
		}
		System.out.println(outputMessage);
        
    }
        
     public static void main(String[] args) {
            
        Parada[] requests = {
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
        
        IntervalPartitioning.findOptimalPartitioning(requests);
    }    
}