//#include <stdio.h>
//#include <stdlib.h>
//#include <unistd.h>
//#include <sys/wait.h>
//void main()
//{
 //pid_t pid1, pid2;
 //printf("AAA \n");
 //pid1 = fork();
 //if (pid1==0)
 //{
 //printf("BBB \n");
 //}
 //else
 //{
 //pid2 = fork();
 //printf("CCC \n");
 //}
 //exit(0);
//}
//la salida que genera es aaa ccc bbb ccc aunque tambien me sale aaa ccc ccc bbb dependiendo de la velocidad de los procesos
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main()
{
 pid_t pid1, pid2;
 printf("AAA %d\n",getpid());
 pid1 = fork();
 if (pid1==0)
 {
 printf("BBB %d\n",getpid());
 }
 else
 {
wait(NULL);
 pid2 = fork();
  wait(NULL);
 printf("CCC %d\n",getpid());
 }
 exit(0);
}


