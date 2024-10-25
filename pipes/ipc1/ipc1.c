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
                read(fd[0], buffer, 70);
                printf("soy el proceso hijo con pid %d \n",getpid());
                printf("\t Mensaje leido del pipe: %s \n", buffer);
     
     }
     
     else
     
     {	
		time_t t;
    		time(&t);
                close(fd[0]); // Cierra el descriptor de lectura
                write(fd[1], ctime(&t), 70);  
                wait(NULL);    
     }
     
        
}
