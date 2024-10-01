#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t pid1, pid2,i,j, term1,term2;

  pid1 = fork();

  if (pid1 == 0 )  
  {      
 	sleep(10);
 	printf("hijo 1 despierto\n");
  }
  else    
  {  
	pid2=fork();
	if(pid2 == 0){
	printf("mi pid del segundo hijo es %d y la de mi padre es %d \n",getpid(),getppid());
	
	}else{
	wait(NULL);//como nos da igual quien acaba pongo solo wait null 
	wait(NULL);//si no usariamos waitpid para esperar especificos
	printf("soy el padre \n");
	}
	
  }
  
   exit(0);
}
