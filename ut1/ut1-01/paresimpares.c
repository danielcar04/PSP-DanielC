#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t pid1, pid2,i,j, term1,term2;//establecer variables
  
  
  // Se crea un proceso hijo, la función fork() devuelve:
  // un valor negativo -> si se produce cualquier error
  // 0 -> si estamos en el proceso hijo
  // un valor positivo (pid del hijo) -> si estamos en el proceso padre

  pid1 = fork();

  if (pid1 == 0 )  //Nos encontramos en Proceso hijo 
  {      
 
	printf("primer hijo \n");
	printf("pares\n");
	  for(i = 1;i<=100;i++){ 
  		if(i % 2 ==0){
		printf("%d, ",i);
		}
	}
	printf("\n");
  }
  else    //Nos encontramos en Proceso padre 
  {  
	pid2=fork();
	if(pid2 == 0){
	
	printf("soy el segundo hijo \n");
	printf("impares\n");
		  for(i = 1;i<=100;i++){ 
  		if(i % 2 !=0){
		printf("%d, ",i);
		}
	}
	printf("\n");
	}else{
	wait(NULL);//como nos da igual quien acaba pongo solo wait null 
	wait(NULL);//si no usariamos waitpid para esperar especificos
	printf("soy el padre \n");
	}
  }
  
   exit(0);
}
