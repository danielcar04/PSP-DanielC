#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t varpid,varpid2,varpid3,varpid4,varpid5;
  
 int pid = getpid();
  varpid = fork();

  if (varpid == 0 )  //Nos encontramos en Proceso hijo 
  {      
   int pid2 = getpid();  
      varpid2 = fork();
	  if (varpid2 == 0 )  //Nos encontramos en Proceso hijo 
	  {        
	      varpid3 = fork();
			  if (varpid3 == 0 )  //Nos encontramos en Proceso hijo 
			  {        
			    	printf("Soy el proceso varpid3 con pid %d y mi abuelo es %d\n",getpid(),pid2); 	  
			  }
			  else    //Nos encontramos en Proceso padre 
			  {  
			  waitpid(varpid3,NULL,0);
			   printf("Soy el proceso varpid2 con pid %d y mi abuelo es %d\n",getpid(),pid);      		   
			  }	  
	  }
	  else    //Nos encontramos en Proceso padre 
	  {  
	    varpid4 = fork();
		  if (varpid4 == 0 )  //Nos encontramos en Proceso hijo 
		  {        
		     varpid5 = fork();
			  if (varpid5 == 0 )  //Nos encontramos en Proceso hijo 
			  {        
			    	printf("Soy el proceso varpid5 con pid %d y mi abuelo es %d\n",getpid(),pid2); 	  
			  }
			  else    //Nos encontramos en Proceso padre 
			  {  
			  waitpid(varpid5,NULL,0);
			   printf("Soy el proceso varpid4 con pid %d y mi abuelo es %d\n",getpid(),pid);         
			  }  
		  }
		  else    //Nos encontramos en Proceso padre 
		  {  
		  waitpid(varpid2,NULL,0);
		 waitpid(varpid4,NULL,0);
		   printf("Soy el proceso varpid con pid %d \n",getpid());       
		  }     
	  }	  
  }
  else    //Nos encontramos en Proceso padre 
  {  
  wait(NULL);
   printf("Soy el proceso padrecon pid %d \n",getpid());      
   
  }
   exit(0);
}
