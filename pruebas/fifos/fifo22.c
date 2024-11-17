//Proceso que lee del PIPE FIFO
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 



int main(void)
{
  int fp;  
  int p, bytesleidos,buffer;
  p=mkfifo("FIFO1", S_IFIFO|0666);//permiso de lectura y escritura
   fp = open("FIFO1", 0);  
   bytesleidos= read(fp, &buffer, sizeof(buffer)); 

   printf("Leyendo informacion del pipe FIFO2...");
   printf(" %d\n",buffer);
   int a=buffer;
   for(int i = 1; i<buffer;i++){
   printf("multiplicando %d por %d\n",a,i);
   a=a*i;
   }
      
   fp = open("FIFO1", 1);
   printf("el factorial de %d es %d\n",buffer,a);
  printf("Mandando información al pipe FIFO...%d\n",a);
  write(fp,&a, sizeof(a));
 close(fp);
  unlink("FIFO01");
}
