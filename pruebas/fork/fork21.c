#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t varpid, varpid2,varpid3;
  

  varpid = fork();

  if (varpid == 0 )  //Nos encontramos en Proceso hijo 
  {        
    	varpid3 =fork();
	   if (varpid3 == 0 )  //Nos encontramos en Proceso hijo 
	  {    
		  if(getpid() %2==0){
		  	printf("mi pid %d es par y mi padre es %d\n",getpid(),getppid());
		  }else{
		  	printf("mi pid %d es impar\n",getpid());
		  }   
	  }
	  else    //Nos encontramos en Proceso padre
	{ 
	wait(NULL);
	    	 if(getpid() %2==0){
		  	printf("mi pid %d es par y mi padre es %d\n",getpid(),getppid());
		  }else{
		  	printf("mi pid %d es impar\n",getpid());
		  }   
  	}
  }
  else    //Nos encontramos en Proceso padre 
  {  
  varpid2 =fork();
	   if (varpid2 == 0 )  //Nos encontramos en Proceso hijo 
	  {        
		    if(getpid() %2==0){
		  	printf("mi pid %d es par y mi padre es %d\n",getpid(),getppid());
		  }else{
		  	printf("mi pid %d es impar\n",getpid());
		  }
	  }
	  else    //Nos encontramos en Proceso padre 
	  { 
	  wait(NULL);
	  wait(NULL);
	 	 if(getpid() %2==0){
		  	printf("mi pid %d es par y mi padre es %d\n",getpid(),getppid());
		  }else{
		  	printf("mi pid %d es impar\n",getpid());
		  } 
	  }
	  }
   exit(0);
}
