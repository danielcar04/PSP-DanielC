#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <stdio.h>
#include <time.h>

void main(){

     int fd[2]; 
     char buffer[70];
     pid_t pid;
    
     // Creamos el pipe
     pipe(fd); 
     
     //Se crea un proceso hijo
     pid = fork();

     if (pid==0)
     
     {
                close(fd[1]); // Cierra el descriptor de escritura
                int a[2];
                int j;
                int x=0;
                int r =0;
                for (int i = 0;i<3;i++){
                read(fd[0], &j, sizeof(j));
                printf("\t numero recibido: %d \n", j);
                a[i]=j; 
                }
                r=a[0]+a[1];
		printf("\t suma total de %d y %d es %d \n",a[0],a[1], r);
		r=a[0]-a[1];
		printf("\t resta total de %d y %d es %d \n",a[0],a[1], r);
     		r=a[0]*a[1];
		printf("\t mult total de %d y %d es %d \n",a[0],a[1], r);
		r=a[0]/a[1];
		printf("\t div total de %d y %d es %d \n",a[0],a[1], r);
     }
     
     else
     
     {	
		
                close(fd[0]); // Cierra el descriptor de lectura
                int j=0;
                for (int i = 0;i<3;i++){
                j=rand() % 50;
                write(fd[1],&j, sizeof(j));
                }
                wait(NULL);    
     }
     
        
}
