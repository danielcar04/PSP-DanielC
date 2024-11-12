#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <stdio.h>
#include <time.h>

void main(){

     int fd[2]; 
     int pp[2];
     char buffer[70];
     pid_t pid;
    
     // Creamos el pipe
     pipe(fd); 
     pipe(pp);
     
     //Se crea un proceso hijo
     pid = fork();

     if (pid==0)
     
     {
                int j;
                printf("dime tu nif sin letra\n");
                scanf("%d",&j);
                write(fd[1],&j, sizeof(&j));
            	close(fd[1]); // Cierra el descriptor de escritura
            	
                int a,b;
                read(pp[0], &a, 1);
                char letra[] = "TRWAGMYFPDXBNJZSQVHLCKE";
                b=a;
                printf("la letra del nif es: %c \n", letra[b]);
                close(pp[0]); // Cierra el descriptor de lectura
     }
     
     else
     
     {			
     		
                int a,j,x;
               
                read(fd[0], &j, sizeof(&j));
                x=j;
                
		close(fd[0]); // Cierra el descriptor de lectura
                a=x%23;
                
                write(pp[1],&a, sizeof(&a));
                close(pp[1]); // Cierra el descriptor de escritura
                wait(NULL);
                 
     }
     
        
}
