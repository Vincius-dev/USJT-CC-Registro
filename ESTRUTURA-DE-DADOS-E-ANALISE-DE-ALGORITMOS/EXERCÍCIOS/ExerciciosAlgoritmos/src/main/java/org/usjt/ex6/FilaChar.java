package org.usjt.ex6;

public class FilaChar {

	private int tamanho, front, rear;
	private char vet[];
		
	FilaChar(){
		tamanho = 5;
		vet = new char[5];
		front = 0;
		rear = 0;		
	}
	
	FilaChar(int n) {
	   tamanho = n;
		vet = new char[tamanho];
		front = 0;
		rear = 0;
	}
	
	int next(int n) {
		if(n == tamanho-1)
			return 0;
		else
			return n+1;
	   // return (n+1)%tamanho;
   }			
		
	boolean isfull(){
		if (next(rear) == front)
			return true;
		else
			return false;
	}
		
	boolean isempty(){
		if (rear == front)
			return true;
		else
			return false;
	}
		
	void store(char elem){
		if(isfull()){ 
			System.out.println("Overflow!");
			System.exit(1);
		}
		else {
			vet[rear]=elem;
			rear = next(rear);
		}	
	}
		
	char retrieve(){
		if(isempty()){
			System.out.println("Underflow!");
			System.exit(1);
			//return '*';
		}	
		//else
			char aux = vet[front];
			front = next(front);
			return aux;
	}
		 
	void destroy(){
		front = rear; 
	}

}
