#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t varpid,numpadre,numhijo,i,j;//establecer variables
  
  
  // Se crea un proceso hijo, la función fork() devuelve:
  // un valor negativo -> si se produce cualquier error
  // 0 -> si estamos en el proceso hijo
  // un valor positivo (pid del hijo) -> si estamos en el proceso padre

  varpid = fork();

  if (varpid == 0 )  //Nos encontramos en Proceso hijo 
  {       
  for(i = 0;i<100;i++){ 
  	
	printf("hijo : %d \n",i);
	}
  }
  else    //Nos encontramos en Proceso padre 
  {  
  	  for(i = 0;i<100;i++){ 
  	
	printf("padre : %d \n",i);
	}
  }
  
   exit(0);
}
