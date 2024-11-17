#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t varpid,varpid2,varpid3,varpid4;
  
  int acumulado = getpid();

  varpid = fork();

  if (varpid == 0 )  //Nos encontramos en Proceso hijo 
  {        
	      varpid2 = fork();

	  if (varpid2 == 0 )  //Nos encontramos en Proceso hijo 
	  {        
	    if(getpid() %2 == 0){
	    printf("Soy el proceso varpid2 soy par e incremento %d\n",(acumulado+10));    
	    }else{
	    printf("Soy el proceso varpid2 soy impar e decremento %d\n",(acumulado-100)); 
	    }	  

	  }
	  else    //Nos encontramos en Proceso padre 
	  {  
	  waitpid(varpid2,NULL,0);
	   	    if(getpid() %2 == 0){
	    printf("Soy el proceso varpid soy par e incremento %d\n",(acumulado+10));    
	    }else{
	    printf("Soy el proceso varpid soy impar e decremento %d\n",(acumulado-100)); 
	    }     
	   
	  }	  

  }
  else    //Nos encontramos en Proceso padre 
  {  
	    varpid3 = fork();

	  if (varpid3 == 0 )  //Nos encontramos en Proceso hijo 
	  {        
	     varpid4 = fork();

		  if (varpid4 == 0 )  //Nos encontramos en Proceso hijo 
		  {        
		    	    if(getpid() %2 == 0){
			    printf("Soy el proceso varpid4 soy par e incremento %d\n",(acumulado+10));    
			    }else{
			    printf("Soy el proceso varpid4 soy impar e decremento %d\n",(acumulado-100)); 
			    }	  

		  }
		  else    //Nos encontramos en Proceso padre 
		  {  
		  waitpid(varpid4,NULL,0);
		    if(getpid() %2 == 0){
		    printf("Soy el proceso varpid3 soy par e incremento %d\n",(acumulado+10));    
		    }else{
		    printf("Soy el proceso varpid3 soy impar e decremento %d\n",(acumulado-100)); 
		    }     
		   
		  }	  

	  }
	  else    //Nos encontramos en Proceso padre 
	  {  
	  waitpid(varpid,NULL,0);
	  waitpid(varpid3,NULL,0);
	   	    if(getpid() %2 == 0){
		    printf("Soy el proceso padre soy par e incremento %d\n",(acumulado+10));    
		    }else{
		    printf("Soy el proceso padre soy impar e decremento %d\n",(acumulado-100)); 
		    }     
	   
	  }     
   
  }
   exit(0);
}
