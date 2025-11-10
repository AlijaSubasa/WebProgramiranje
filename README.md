**Autori:**  
- Alija Subašić  
- Amar Berbić  

Opis logike dodavanja novog modela i ostvarene relacije
U aplikaciju je dodan novi model Veterinarian, koji je povezan s modelom Appointments preko veze @ManyToOne.
Svaki termin (Appointments) može imati jednog veterinara.
Pet (Pet) ima više termina (@OneToMany veza s Appointments).
Logika dodavanja omogućava da se prilikom kreiranja termina odabere ljubimac i veterinar, a veza se automatski postavlja u entitetima.

Funkcionalnosti controller-a
Obični (Thymeleaf) controller:
REST controller (VeterinarianRestController):

/api/veterinarians – vraća listu veterinara u JSON formatu
Kasnije se može proširiti POST/PUT metodama za dodavanje i izmjenu veterinara.

Konfiguracija baze
Baza: MySQL
URL: jdbc:mysql://localhost:3306/vetclinic?useSSL=false&serverTimezone=UTC
Username: root
Password: root
Spring Boot automatski mapira entitete Pet, Appointments i Veterinarian u odgovarajuće tabele koristeći JPA/Hibernate.

*u odnosu na proslu vjezbu je dodan novi model veterinar i nad njim je samo vrsen zadatak dodavanja i prikaz, a obrisan je data jer je on in-memory 
