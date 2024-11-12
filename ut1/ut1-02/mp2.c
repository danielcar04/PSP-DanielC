#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t pid1,pid2,pidpadre,pidhijo,pidnieto;//establecer variables
  
 

  pid1 = fork();

  if (pid1 == 0 )  //Nos encontramos en Proceso hijo 
  {      
  	pid2 = fork();
  	if (pid2 == 0){
  	printf("mi pid de nieto es %d y la de mi padre es %d \n",getpid(),getppid());
  	}else{
  	wait(NULL);
	printf("mi pid de hijo es %d y la del nieto es %d \n",getpid(),getppid());
	}
  }
  else    //Nos encontramos en Proceso padre 
  {  
	pidhijo = wait(NULL);
	printf("soy el padre con id %d y mi hijo tiene una id de %d \n", getpid(), pidhijo);
  }
  
   exit(0);
}
