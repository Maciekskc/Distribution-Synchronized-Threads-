# Distribution-Synchronized-Threads-

Uruchamiany z Klasy "Frame"


Opis programu :
Program, s³u¿¹cy zasadniczo jako animacja

Zsynchronizowane w¹tki wspó³pracuj¹ ze sob¹
W¹tki:
  Kucharz: wysy³a rz¹dnia dostarczenia mu sk³adników
  Mieszacz: odbiera rz¹dania kucharza i przeszukuje zasobniki w poszukiwaniu dostêpnych przpraw
            i zwraca je kucharzowi. Je¿eli nie ma dostêpnych sk³adników uruchamiany jest w¹tek dostawcy
  Dostawca: uzupe³nia zasobniki 