#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t pid1, pid2,pid3,pid4,i,j, term1,term2;

  pid1 = fork();
  if (pid1 == 0 )  
  {      
  	printf("soy el primer hijo \n");
 	if(getpid()%2==0){
 	printf("soy par con pid %d y mi padre tiene %d de pid\n",getpid(),getppid());
 	}else{
 	printf("soy impar con pid %d\n",getpid());
 	}
  }
  else    
  {  
	pid2=fork();
	if(pid2 == 0){
		pid3=fork();
		if(pid3==0){
			printf("soy el nieto\n");
	 		if(getpid()%2==0){
 			printf("soy par con pid %d y mi padre tiene %d de pid\n",getpid(),getppid());
 			}else{
 			printf("soy impar con pid %d\n",getpid());
 			}
		}else{
			wait(NULL);//esperamos a que acabe el nieto osea su hijo
			printf("soy el segundo hijo\n");
	 		if(getpid()%2==0){
 			printf("soy par con pid %d y mi padre tiene %d de pid\n",getpid(),getppid());
 			}else{
 			printf("soy impar con pid %d\n",getpid());
 			}
		}
	}else{
	wait(NULL);//como nos da igual quien acaba pongo solo wait null 
	wait(NULL);//si no usariamos waitpid para esperar especificos
	wait(NULL);
	printf("soy el padre \n");
	}
	
  }
  
   exit(0);
}
