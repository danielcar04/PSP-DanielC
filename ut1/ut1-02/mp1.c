#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t pid1,pidpadre,idhijo;//establecer variables
  
 

  pid1 = fork();

  if (pid1 == 0 )  //Nos encontramos en Proceso hijo 
  {      
  	
	printf("daniel carriedo \n");
  }
  else    //Nos encontramos en Proceso padre 
  {  
	idhijo = wait(NULL);
	printf("soy el padre con id %d y mi hijo tiene una id de %d \n", getpid(), idhijo);
  }
  
   exit(0);
}
