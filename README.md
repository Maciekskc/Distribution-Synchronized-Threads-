# Distribution-Synchronized-Threads-

Uruchamiany z Klasy "Frame"


Opis programu :
Program, s�u��cy zasadniczo jako animacja

Zsynchronizowane w�tki wsp�pracuj� ze sob�
W�tki:
  Kucharz: wysy�a rz�dnia dostarczenia mu sk�adnik�w
  Mieszacz: odbiera rz�dania kucharza i przeszukuje zasobniki w poszukiwaniu dost�pnych przpraw
            i zwraca je kucharzowi. Je�eli nie ma dost�pnych sk�adnik�w uruchamiany jest w�tek dostawcy
  Dostawca: uzupe�nia zasobniki 