//Proceso que escribe en PIPE FIFO
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>

int main()
{

time_t t; 
srand((unsigned) time(&t)); 
  int fp,p;
  int x = rand() % 10;
  fp = open("PIPE02", 1);
  printf("Mandando información al PIPE02...\n");
  write(fp,&x,sizeof(x));
 close(fp); 
 p=mkfifo("PIPE02", S_IFIFO|0666);//permiso de lectura y escritura
 fp = open("PIPE02", 0);
  int a, b; 
   p=read(fp, &a, sizeof(a)); 
   close(fp); 
   printf("Leyendo informacion del PIPE02...\n");
   b=a;
   printf("el factorial de %d es %d\n",x,b);
  
  unlink("PIPE02");
}
