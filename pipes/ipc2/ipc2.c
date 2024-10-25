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
                int a[70];
                int j;
                int x=0;
                int r =0;
                while(1){
                read(fd[0], &j, sizeof(j));
                if(j=='+'){
                printf("\t suma recibida +\n");
                for (int y = 0;y<x;y++){
                r=r+a[y];
                }
                break;
                }else{
                x=x+1;
                printf("\t numero recibido: %d \n", j);
                a[x-1]=j;
                }
                }
		printf("\t suma total %d \n", r);

     
     }
     
     else
     
     {	
		
                close(fd[0]); // Cierra el descriptor de lectura
                int j=0;
                for (int i = 0;i<5;i++){
                j=rand() % 18;
                write(fd[1],&j, sizeof(j));
                }
                write(fd[1],"+", 70);
                wait(NULL);    
     }
     
        
}
