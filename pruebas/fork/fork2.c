#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t varpid, varpid2;
  

  varpid = fork();

  if (varpid == 0 )  //Nos encontramos en Proceso hijo 
  {      
    varpid2 = fork();
    if (varpid2 == 0)
    {
    printf("Soy el proceso p3 %d y mi padre es %d\n",getpid(),getppid()); 
    }else{  
    wait(NULL);
    printf("Soy el proceso p2 %d y mi padre es %d\n",getpid(),getppid()); 	  
    }
  }
  else    //Nos encontramos en Proceso padre 
  {  
  wait(NULL);
   printf("Soy el proceso p1 %d y mi hijo es %d\n",getpid(),varpid);      
   
  }
   exit(0);
}
