#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
void main()
{
pid_t pid1;
 printf("CCC \n");
 if (fork()!=0)
 {
 wait(NULL);
 printf("AAA \n");
 } else {

 printf("BBB \n");
 }
 exit(0);
}
//este codigo primero realizará las c luego las a y por ultimo las b (las cuales pueden convertirse en huerfanas)
//dependiendo de los procesos puede o no crear huerfanos


//#include <stdio.h>
//#include <stdlib.h>
//#include <unistd.h>
//void main()
//{
 //printf("CCC \n");
 //if (fork()!=0)
 //{
 //printf("AAA \n");
 //} else printf("BBB \n");
 //exit(0);
//}


