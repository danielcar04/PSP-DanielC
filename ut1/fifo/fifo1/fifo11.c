//Proceso que escribe en PIPE FIFO
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 


int main()
{
  int fp,p;
  int x = rand() % 10;
  fp = open("FIFO1", 1);
  printf("Mandando información al pipe FIFO...\n");
  write(fp,&x,sizeof(x));
 
  
   p=mkfifo("FIFO2", S_IFIFO|0666);//permiso de lectura y escritura

  int buffer,a,bytesleidos;
   
   fp = open("FIFO2", 0);  
   bytesleidos= read(fp, &buffer, 1); 
   printf("Leyendo informacion del pipe FIFO2...\n");
   a=buffer;
   printf("el factorial de %d es %d\n",x,a);
    
    
  close(fp); 
  return 0; 
}
