#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t pid1, pid2,pid3,i,j, term1,term2;
//voy a llamar en orden de abuelo, padre, hijo y nieto para no perderme
  pid1 = fork();
  if (pid1 == 0 )//padre o el segundo proceso
  {      
	pid2=fork();
	 if (pid2 == 0 ) {//hijo o el tercer proceso
	 	pid3=fork();
	 	if (pid3 == 0 ) {//nieto o el cuarto proceso
		printf("soy el nieto con pid %d mi padre tiene %d \n",getpid(),getppid());
		printf("y la suma es %d\n",(getpid()+getppid()));
	 	}else{
	 	wait(NULL);//espero al nieto
	 	printf("soy el hijo con pid %d mi padre tiene %d \n",getpid(),getppid());
	 	printf("y la suma es %d\n",(getpid()+getppid()));
	 	}
	 }else{
	 wait(NULL);//espero al hijo
	 printf("soy el padre con pid %d mi padre tiene %d \n",getpid(),getppid());
	 printf("y la suma es %d\n",(getpid()+getppid()));
	 }
  }
  else  //abuelo o el primero proceso  
  {  
	wait(NULL);//espero al padre
	printf("soy el abuelo \n");
	
  }
  
   exit(0);
}

