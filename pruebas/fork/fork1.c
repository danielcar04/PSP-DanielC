#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t varpid;
  

  varpid = fork();

  if (varpid == 0 )  //Nos encontramos en Proceso hijo 
  {        
    printf("Daniel\n");	  

  }
  else    //Nos encontramos en Proceso padre 
  {  
  wait(NULL);
   printf("Soy el proceso padre y mi hijo es %d\n",varpid);      
   
  }
   exit(0);
}
