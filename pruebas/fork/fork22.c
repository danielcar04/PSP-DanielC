#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t varpid,varpid2,varpid3;
  

  varpid = fork();

  if (varpid == 0 )  //Nos encontramos en Proceso hijo 
  {       
  	  varpid2 = fork();
	    if (varpid2 == 0 )  //Nos encontramos en Proceso hijo 
	  {     
	    varpid3 = fork();   
	      if (varpid3 == 0 )  //Nos encontramos en Proceso hijo 
		  {        
		    printf("mi pid es %d el de mi padre es %d y la suma es %d\n",getpid(),getppid(),(getpid()+getppid()));     

		  }
		  else    //Nos encontramos en Proceso padre 
		  {  
		  wait(NULL);
		   printf("mi pid es %d el de mi padre es %d y la suma es %d\n",getpid(),getppid(),(getpid()+getppid()));        
		   
		  }	  
	  }
	  else    //Nos encontramos en Proceso padre 
	  {  
	  wait(NULL);
	   printf("mi pid es %d el de mi padre es %d y la suma es %d\n",getpid(),getppid(),(getpid()+getppid()));      
	   
	  }
  }
  else    //Nos encontramos en Proceso padre 
  {  
  wait(NULL);
   printf("Soy el proceso padre y mi hijo es %d\n",varpid);      
   
  }
   exit(0);
}
