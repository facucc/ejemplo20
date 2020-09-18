# Respuestas laboratorio 3
#### Debug con gdb

``` c
#include <iostream>
#include <cmath>

using namespace std;

int factorial(int number) {
  int fact=1;

  for (int j = 1; j < number; j++) {
    fact = fact * j;
  }

  return fact;
}

double compute_series_value(double x, int n) {
double series_value = 0.0;``` c
double xpow = 1;

  for (int k = 0; k <= n; k++) {
    series_value += xpow / factorial(k);
    xpow = xpow * x;
  }

  return series_value;
}

int main() {
  cout << "This program is used to compute the value of the following series : " << endl;

  cout << "(x^0)/0! + (x^1)/1! + (x^2)/2! + (x^3)/3! + (x^4)/4! + ........ + (x^n)/n! " << endl;

  cout << "Please enter the value of x : " ;
  
  double x;
  cin >> x;

  int n;
  cout << endl << "Please enter an integer value for n : " ;
  
  cin >> n;
  cout << endl;

  double series_value = compute_series_value(x, n);
  cout << "The value of the series for the values entered is " 
    << series_value << endl;

  return 0;
}
``` 



Error de sintaxis en una variable mal escrita
series_value 
Y ademas no estaba inicializada correctamente la variable fact

#### Debug con core dumps
``` c
#include <stdio.h>

void main() {	
    char temp[] = "Paras";
    char* punt=temp;
    int i;
    i=0;   
    punt[3]='F';
    for (i =0 ; i < 5 ; i++ )
        printf("%c\n", temp[i]);
} 
``` 
Analizando el dgb y el core dump
![gdb](/home/facundo/Escritorio/SO1/Laboratorio/lab3/gdb.png)
![coredump](/home/facundo/Escritorio/SO1/Laboratorio/lab3/coredump.png)


### Preguntas

¿Cómo puedo obtener el coredump de un proceso que esta corriendo?

>Se puede obtener en la direccion  /var/lib/systemd/coredump/
En la seccion del man core "Core dumps and systemd"


¿Cómo se llama por defecto los archivos de core dump?
>Los archivos coredump se llaman por defecto "core" o "core.pid"
donde pid es el ID del proceso que produjo el coredump.
El archivo / proc / sys / kernel / core_pattern puede    configurarse para definir un conjunto de especificaciones para utilizarse para nombrar a los core dump.

>Consultando el man en la seccion "Naming of core dump files" estan las especificaciones para configurar los nombres de los coredump.

       

¿Qué restricciones de tamaño tienen por defecto y con qué comando y función puedo modificarlas?
>El maximo tamaño por defecto es 128 bytes
Con el comando "getrlimit" puedo modificar el tamaño
