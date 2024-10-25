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
                
                int a;
                int j;
                read(fd[0], &j, sizeof(j));
                a=j;
                for (int i = 1;i<=j;i++){
                printf("\t multiplicando: %d por %d\n", a,i);
                a=a*i; 
                }
                close(fd[0]); // Cierra el descriptor de lectura
                write(fd[1],&a, sizeof(j));
                close(fd[1]); // Cierra el descriptor de escritura
     }
     
     else
     
     {	
		
                
                int j=0;
                j=rand() % 10;
                write(fd[1],&j, sizeof(j));
                wait(NULL);    
            	close(fd[1]); // Cierra el descriptor de escritura
                int a;
                read(fd[0], &a, sizeof(j));
                printf("\t el factorial de %d es %d \n", j,a);
                close(fd[0]); // Cierra el descriptor de lectura
     }
     
        
}
