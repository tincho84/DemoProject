REQUISITOS
Apache Maven 3.5.2
Java version: 1.8.0_144

IDEA UTILIZADA PARA LA RESOLUCIÓN:
Se utilizo springboot para enfocarme solo en la solución logica del problema.
Se utiliza una cola concurrente en la cual entrega empleados segun la prioridad de los mismos.
La entrada para poder responder a las llamadas asociando un empleado disponible, se basa en servicios rest.
Estos utilizan el dispatcher para la asociación entre la llamada y el cliente disponible.
No se mantienen variables de clase con estados por temas de concurrencia. 
Los empleados para simular que estan atendiendo a la llamada, esperan un tiempo generico entre 5 y 10 seg.

- Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.
La cola tiene la capacidad de esperar un tiempo si no hay empleados disponibles el cual puede ser configurable, actualmente esta en 5 segundos.
Luego de ese tiempo se devuelve un mensaje indicando que no se puede atender momentaneamente.

- Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes.
La cola esta configurada con 10 empleados, luego de esto el comportamiento es similar al punto anterior.
Se podría cambiar el tipo de colección incrementando la cantidad de empleados para atender y también haciendo el tamaño de la cola dinámico.

También utilizaría alguna librería como log4j para todo lo que es el log de la aplicación.

RESPECTO A LOS TEST
Utilice "DispatcherParallelExecutionTest", para simular una ejecución concurrente de 10 usuarios. Lo que hace esta clase es 
ejecutar todos los test de otra clase, en este caso "DispatcherParallelTest". Sin embargo, para esto ultimo hubiera preferido
usar jmeter para poder cargarlo y ejecutar concurrentemente.


RESUMEN DE CLASES UTILIZADAS:

Call.java
---------
Representa la llamada con los datos de la misma
La idea es que contenga todos los atributos que sea necesario recibir al momento de recibir una llamada.


Employee.java
-------------
Clase abstracta padre de todos los posibles empleados que puedan resolver una llamada
Los tipos de empleado deben heredar de esta e implementar el metodo "makeOwnLogic".
los tipos de empleados actuales son 
Operator - prioridad 1
Director - prioridad 3
Supervisor - prioridad 2
La prioridad indica el orden en que atienden las llamadas mientras haya disponibles.


Dispatcher.java
---------------
Mantiene los empleados disponibles para atender llamadas, resuelve el llamado, y vuelve el empleado a la cola
Maneja la cola de usuarios disponibles.


RandomTime.java
---------------
Devuelve un tiempo random entre 5 y 10,que es el tiempo que puede durar una llamada


ResultInfo.java
---------------
Encapsula el resultado luego de atender una llamada


User.java
---------
Representa el usuario que sera atendido


CallDispatchController.java
---------------------------
Servicios rest disponibles para consumir contra el dispatcher. Punto de entrada para la cola de usuarios 
que responden llamados

