#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <time.h>
void main(){
     int fd[2]; 
     char buffer[100];
     pid_t pid;   
     // Creamos el pipe
     pipe(fd);      
     //Se crea un proceso hijo
     pid = fork();
     if (pid==0)
     {
                close(fd[1]); // Cierra el descriptor de escritura
                printf("El hijo se dispone a leee del PIPE \n");
                read(fd[0], &buffer, 70);
                char *lectura = buffer;
                printf("\t Mensaje leido del pipe: %s \n", lectura);
     
     }
     else
     {
     		 time_t hora;
		 char *fecha ;
		 time(&hora);
		 fecha = ctime(&hora) ;
                close(fd[0]); // Cierra el descriptor de lectura
                printf("El padre escribe en el PIPE...%s\n",fecha);
                write(fd[1], fecha, 70);  
                wait(NULL);    
     } 
}


