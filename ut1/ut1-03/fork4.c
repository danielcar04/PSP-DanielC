#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t pid1,acumulado;
//voy a llamar en orden de abuelo, padre, hijo y nieto para no perderme
  acumulado = getpid();
  pid1 = fork();
  if (pid1 == 0 )//padre o el segundo proceso
  {      
	  pid_t pid3 = fork();
  		if (pid3 == 0 )//padre o el segundo proceso
  		{      
			if(getpid()%2==0)
			{
				printf("soy par %d y aumento, resultado: %d\n",getpid(),(acumulado+10));
			}
			else
			{
				printf("soy impar %d y decremento, resultado: %d\n",getpid(),(acumulado-100));
			}
  		}
  		else
  		{
  			waitpid(pid3,NULL,0);
  				if(getpid()%2==0)
  				{
					printf("soy par %d y aumento, resultado: %d\n",getpid(),(acumulado+10));
				}
				else
				{
					printf("soy impar %d y decremento, resultado: %d\n",getpid(),(acumulado-100));
				}
  		}
  }
  else  //abuelo o el primero proceso  
  {  
  	pid_t pid2=fork();
  	if(pid2==0)
  	{
    		pid_t pid4 = fork();
  		if (pid4 == 0 )//padre o el segundo proceso
  		{      
			if(getpid()%2==0)
			{
				printf("soy par %d y aumento, resultado: %d\n",getpid(),(acumulado+10));
			}
			else
			{
				printf("soy impar %d y decremento, resultado: %d\n",getpid(),(acumulado-100));
			}
  		}
  		else
  		{
  		waitpid(pid4,NULL,0);
  				if(getpid()%2==0)
  				{
					printf("soy par %d y aumento, resultado: %d\n",getpid(),(acumulado+10));
				}
				else
				{
					printf("soy impar %d y decremento, resultado: %d\n",getpid(),(acumulado-100));
				}
  		}
  	}
  	else
  	{
		waitpid(pid1,NULL,0);
		waitpid(pid2,NULL,0);
		printf("soy el pid1 con pid %d \n",getpid());
	}	
  }
  
   exit(0);
}
