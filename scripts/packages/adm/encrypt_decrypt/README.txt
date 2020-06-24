Author: Sebastián Quesada Velluti
Date: 23/06/2020

Para la encriptación primero hay que otorgar permiso de usar dbms_crypto a todos los usuarios.
Para esto hay que conectarse desde SYS. Esto se hace conectando con 'SYS as SYSDBA' como usuario 
y la contraseña es la misma usada para conectarse a SYSTEM.
Luego se ejecuta el grant que está en encrypt_decrypt_privileges.sql

En encrypt_decrypt.sql está el paquete con las funciones de encrypt y decrypt, si se ejecuta
este script se crea el package y el body normalmente, sin embargo por seguridad es mejor esconder 
el código de encriptamiento con una utilidad que se realiza desde el cmd llama wrapping. 
En la carpeta de encrypt_decrypt ya está el encrypt_decrypt.sql.wrp que es el mismo código del 
package pero oculto.

Pueden ejecutar directamente encrypt_decrypt.sql.wrp desde ADM y se guardará el paquete con
el código oculto.

Wrapping: https://oracle-base.com/articles/10g/wrap-and-dbms_ddl-10gr2 
