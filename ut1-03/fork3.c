#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t pid1, pid2,pid3,pid4,pid5,pid6,pidab1, pidab2;
//voy a llamar en orden de abuelo, padre, hijo y nieto para no perderme
  pidab1 = getpid();
  pid1 = fork();
  if (pid1 == 0 )//padre o el segundo proceso
  {      
  pidab2=getpid();
	pid2=fork();
	if (pid2 == 0 ) {//hijo o el tercer proceso
	 	pid4=fork();
	 			if (pid4 == 0 ) {//nieto o el cuarto proceso
				printf("soy el pid5 con pid %d y mi abuelo es %d\n",getpid(),pidab2);
	 			}
	 			else{
	 			waitpid(pid4,NULL,0);
	 			printf("soy el pid3 con pid %d y mi abuelo es %d\n",getpid(),pidab1);
	 			}
	 }else{
	 pid3=fork();
	 if (pid3 == 0 ) {//hijo o el tercer proceso
	 		pid5=fork();
	 			if (pid5 == 0 ) {//nieto o el cuarto proceso
				printf("soy el pid6 con pid %d y mi abuelo es %d\n",getpid(),pidab2);
	 			}else{
	 			waitpid(pid5,NULL,0);
	 			printf("soy el pid4 con pid %d y mi abuelo es %d\n",getpid(),pidab1);
	 			}
	 }else{//recuerda poner este elseeeeeee
	 waitpid(pid2,NULL,0);
	 waitpid(pid3,NULL,0);
	 printf("soy el pid2 con pid %d \n",getpid());
	 }
	 }
  }
  else  //abuelo o el primero proceso  
  {  
	wait(NULL);//espero al padre
	printf("soy el pid1 con pid %d \n",getpid());
	
  }
  
   exit(0);
}
